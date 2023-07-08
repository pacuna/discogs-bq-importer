package bq.models.artist

import com.spotify.scio.bigquery.types.BigQueryType

object Types {

  @BigQueryType.toTable
  case class Artist(
                     id: Option[Int],
                     name: Option[String],
                     real_name: Option[String],
                     profile: Option[String],
                     data_quality: Option[String],
                     urls: List[String],
                     name_variations: List[String],
                     group_names: List[Group]
                   )

  case class Group(
                    id: Option[Int],
                    name: Option[String]
                  )
}
