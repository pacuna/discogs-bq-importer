package discogs


import bq.models.artist.Types
import com.spotify.scio.ContextAndArgs
import com.spotify.scio.bigquery.{CREATE_IF_NEEDED, Table, WRITE_TRUNCATE}
import com.spotify.scio.values.SCollection
import org.apache.beam.sdk.io.Compression
import org.apache.beam.sdk.io.xml.XmlIO
import xml.artist._

import scala.jdk.CollectionConverters._


object ArtistsJob {
  def main(cmdlineArgs: Array[String]): Unit = {
    val (sc, args) = ContextAndArgs(cmdlineArgs)

    // to test before loading the complete dataset
    val artistsUri = "src/main/resources/artists.xml"
    val input = args.getOrElse("input", artistsUri)
    val output = args.getOrElse("output", "artists")

    val xmlInputTransform = XmlIO.read()
      .from(input)
      .withRootElement("artists")
      .withRecordElement("artist")
      .withRecordClass(classOf[Artist])
      .withCompression(Compression.GZIP)

    val xmls: SCollection[Artist] = sc
      .customInput("fromXML", xmlInputTransform)

    xmls
      .map { a =>
        val groups = a.getGroupNames.asScala.map { g =>
          Types.Group(
            id = Option(g.getId),
            name = Option(g.getValue)
          )
        }

        Types.Artist(
          id = Option(a.getId),
          name = Option(a.getName),
          real_name = Option(a.getRealName),
          profile = Option(a.getProfile),
          data_quality = Option(a.getDataQuality),
          urls = if (a.getUrls != null) a.getUrls.asScala.toList else List.empty,
          name_variations = if (a.getNameVariations != null) a.getNameVariations.asScala.toList else List.empty,
          group_names = if (groups != null) groups.toList else List.empty
        )
      }
      .saveAsTypedBigQueryTable(Table.Spec(output), writeDisposition = WRITE_TRUNCATE, createDisposition = CREATE_IF_NEEDED)

    val result = sc.run().waitUntilFinish()
  }

}
