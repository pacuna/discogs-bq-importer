package bq.models.label

import com.spotify.scio.bigquery.types.BigQueryType

object Types {
  @BigQueryType.toTable
  case class Label(
                    id: Option[Int],
                    name: Option[String],
                    contact_info: Option[String],
                    profile: Option[String],
                    data_quality: Option[String],
                    urls: List[String],
                    sub_labels: List[SubLabel]
                  )

  case class SubLabel(id: Option[Int], name: Option[String])

}
