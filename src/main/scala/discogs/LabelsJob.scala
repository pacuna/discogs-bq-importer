package discogs


import bq.models.label.Types
import com.spotify.scio.ContextAndArgs
import com.spotify.scio.bigquery.{CREATE_IF_NEEDED, Table, WRITE_TRUNCATE}
import com.spotify.scio.values.SCollection
import org.apache.beam.sdk.io.Compression
import org.apache.beam.sdk.io.xml.XmlIO
import xml.labelrenamed._

import scala.jdk.CollectionConverters._


object LabelsJob {
  def main(cmdlineArgs: Array[String]): Unit = {
    val (sc, args) = ContextAndArgs(cmdlineArgs)

    // to test before loading the complete dataset
    val labelsUri = "src/main/resources/labels.xml"
    val input = args.getOrElse("input", labelsUri)
    val output = args.getOrElse("output", "labels")

    val xmlInputTransform = XmlIO.read()
      .from(input)
      .withRootElement("labels")
      .withRecordElement("label")
      .withRecordClass(classOf[Label])
      .withCompression(Compression.GZIP)

    val xmls: SCollection[Label] = sc
      .customInput("fromXML", xmlInputTransform)

    xmls
      .map { l =>
        val subLabels = l.getSubLabels.asScala.map { sl =>
          Types.SubLabel(id = Option(sl.getId), name = Option(sl.getValue))
        }

        Types.Label(
          id = Option(l.getId),
          name = Option(l.getName),
          contact_info = Option(l.getContactInfo),
          profile = Option(l.getProfile),
          data_quality = Option(l.getDataQuality),
          urls = l.getUrls.asScala.toList,
          sub_labels = subLabels.toList
        )
      }
      .saveAsTypedBigQueryTable(Table.Spec(output), writeDisposition = WRITE_TRUNCATE, createDisposition = CREATE_IF_NEEDED)

    val result = sc.run().waitUntilFinish()
  }

}
