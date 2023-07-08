package bq.models.release

import com.spotify.scio.bigquery.types.BigQueryType

object Types {

  @BigQueryType.toTable
  case class Track(position: Option[String], title: Option[String], duration: Option[String])

  @BigQueryType.toTable
  case class Artist(id: Option[Int], name: Option[String], anv: Option[String], join: Option[String], tracks: Option[String])

  @BigQueryType.toTable
  case class Company(id: Option[Int], name: Option[String], cat_no: Option[String])

  @BigQueryType.toTable
  case class Format(name: Option[String], qty: Option[Int], text: Option[String], descriptions: List[String])

  @BigQueryType.toTable
  case class Identifier(identifier_type: Option[String], description: Option[String], value: Option[String])

  @BigQueryType.toTable
  case class Label(name: Option[String], cat_no: Option[String], id: Option[Int])

  @BigQueryType.toTable
  case class Release(
                      id: Option[Int],
                      status: Option[String],
                      artists: List[Artist],
                      title: Option[String],
                      labels: List[Label],
                      extra_artists: List[Artist],
                      genres: List[String],
                      styles: List[String],
                      country: Option[String],
                      released: Option[String],
                      notes: Option[String],
                      data_quality: Option[String],
                      master_id: Option[Int],
                      is_main_release: Option[Boolean],
                      track_list: List[Track],
                      identifiers: List[Identifier],
                      formats: List[Format],
                      companies: List[Company]
                    )
}
