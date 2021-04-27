package shared

import play.api.libs.json._

case class Message(author: String, message: String)

object SharedMessages {
  
  implicit val messageReads = Json.reads[Message]
  implicit val messageWrites = Json.writes[Message]

  def itWorks = "It works!"

}
