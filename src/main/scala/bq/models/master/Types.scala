package bq.models.master

import com.spotify.scio.bigquery.types.BigQueryType

object Types {

  @BigQueryType.toTable
  case class Master(
                     id: Option[Int],
                     main_release: Option[Int],
                     artists: List[Artist],
                     styles: List[String],
                     genres: List[String],
                     year: Option[String],
                     title: Option[String],
                     data_quality: Option[String]
                   )

  case class Artist(id: Option[Int], name: Option[String], anv: Option[String], join: Option[String], tracks: Option[String])
}
