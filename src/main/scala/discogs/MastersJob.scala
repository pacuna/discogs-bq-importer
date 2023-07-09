package discogs


import bq.models.master.Types
import com.spotify.scio.ContextAndArgs
import com.spotify.scio.bigquery.{CREATE_IF_NEEDED, Table, WRITE_TRUNCATE}
import com.spotify.scio.values.SCollection
import org.apache.beam.sdk.io.Compression
import org.apache.beam.sdk.io.xml.XmlIO
import xml.master.Master

import scala.jdk.CollectionConverters._


object MastersJob {
  def main(cmdlineArgs: Array[String]): Unit = {
    val (sc, args) = ContextAndArgs(cmdlineArgs)

    // to test before loading the complete dataset
    val mastersUri = "src/main/resources/masters.xml"
    val input = args.getOrElse("input", mastersUri)
    val output = args.getOrElse("output", "masters")

    val xmlInputTransform = XmlIO.read()
      .from(input)
      .withRootElement("masters")
      .withRecordElement("master")
      .withRecordClass(classOf[Master])
      .withCompression(Compression.GZIP)

    val xmls: SCollection[Master] = sc
      .customInput("fromXML", xmlInputTransform)

    xmls
      .map { m =>
        val artists = m.getArtists.asScala.map { a =>
          Types.Artist(id = Option(a.getId), name = Option(a.getName), anv = Option(a.getAnv), join = Option(a.getJoin), tracks = Option(a.getTracks))
        }

        Types.Master(
          id = Option(m.getId),
          main_release = Option(m.getMainRelease),
          artists = artists.toList,
          styles = m.getStyles.asScala.toList,
          genres = m.getGenres.asScala.toList,
          year = Option(m.getYear),
          title = Option(m.getTitle),
          data_quality = Option(m.getTitle)
        )
      }
      .saveAsTypedBigQueryTable(Table.Spec(output), writeDisposition = WRITE_TRUNCATE, createDisposition = CREATE_IF_NEEDED)

    val result = sc.run().waitUntilFinish()
  }

}
