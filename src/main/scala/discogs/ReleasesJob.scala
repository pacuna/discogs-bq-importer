package discogs


import bq.models.release.Types
import com.spotify.scio.ContextAndArgs
import com.spotify.scio.bigquery.{CREATE_IF_NEEDED, Table, WRITE_TRUNCATE}
import com.spotify.scio.values.SCollection
import org.apache.beam.sdk.io.Compression
import org.apache.beam.sdk.io.xml.XmlIO
import xml.release.Release

import scala.jdk.CollectionConverters._


object ReleasesJob {
  def main(cmdlineArgs: Array[String]): Unit = {
    val (sc, args) = ContextAndArgs(cmdlineArgs)

    // to test before loading the complete dataset
    val releasesUri = "src/main/resources/releases.xml"
    val input = args.getOrElse("input", releasesUri)
    val output = args("output")

    val xmlInputTransform = XmlIO.read()
      .from(input)
      .withRootElement("releases")
      .withRecordElement("release")
      .withRecordClass(classOf[Release])
      .withCompression(Compression.GZIP)

    val xmls: SCollection[Release] = sc
      .customInput("fromXML", xmlInputTransform)

    xmls
      .map { r =>
        val artists = r.getArtists.asScala.map { a =>
          Types.Artist(
            id = if (a.getId != null) Some(a.getId) else None,
            name = Option(a.getName),
            anv = Option(a.getAnv),
            join = Option(a.getJoin),
            tracks = Option(a.getTracks)
          )
        }

        val labels = r.getLabels.asScala.map { l =>
          Types.Label(
            name = Option(l.getName),
            cat_no = Option(l.getCatNo),
            id = if (l.getId != null) Some(l.getId) else None
          )
        }

        val extraArtists = r.getExtraArtists.asScala.map { ea =>
          Types.Artist(
            id = Option(ea.getId),
            name = Option(ea.getName),
            anv = Option(ea.getAnv),
            join = Option(ea.getJoin),
            tracks = Option(ea.getTracks)
          )
        }

        val tracksList = r.getTracklist.asScala.map { t =>
          Types.Track(
            position = Option(t.getPosition),
            title = Option(t.getTitle),
            duration = Option(t.getDuration)
          )
        }

        val identifiers = r.getIdentifiers.asScala.map { i =>
          Types.Identifier(
            identifier_type = Option(i.getType),
            description = Option(i.getDescription),
            value = Option(i.getValue)
          )
        }

        val formats = r.getFormats.asScala.map { f =>
          Types.Format(
            name = Option(f.getName),
            qty = Option(f.getQty),
            text = Option(f.getText),
            descriptions = f.getDescriptions.asScala.toList,
          )
        }

        val companies = r.getCompanies.asScala.map { c =>
          Types.Company(
            id = Option(c.getId),
            name = Option(c.getName),
            cat_no = Option(c.getCatNo)
          )
        }

        Types.Release(
          id = Option(r.getId),
          status = Option(r.getStatus),
          artists = artists.toList,
          title = Option(r.getTitle),
          labels = labels.toList,
          extra_artists = extraArtists.toList,
          genres = r.getGenres.asScala.toList,
          styles = r.getStyles.asScala.toList,
          country = Option(r.getCountry),
          released = Option(r.getReleased),
          notes = Option(r.getNotes),
          data_quality = Option(r.getDataQuality),
          master_id = if (r.getMasterId != null) Some(r.getMasterId.getValue) else None,
          is_main_release = if (r.getMasterId != null) Some(r.getMasterId.getIsMainRelease) else None,
          track_list = tracksList.toList,
          identifiers = identifiers.toList,
          formats = formats.toList,
          companies = companies.toList,
        )
      }
      .saveAsTypedBigQueryTable(Table.Spec(output), writeDisposition = WRITE_TRUNCATE, createDisposition = CREATE_IF_NEEDED)

    val result = sc.run().waitUntilFinish()
  }

}
