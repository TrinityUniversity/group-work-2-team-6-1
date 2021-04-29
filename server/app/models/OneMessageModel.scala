package models

import shared.SharedMessages

object OneMessageModel {
    var author: String = ""
    var message: String = ""
    /*implicit val msgReads = Json.reads[AuthorMessage]
    implicit val msgFormat = Json.format[AuthorMessage]*/
    def receiveMessage(newMessage: String): String = {
        val oldMessage = message
        message = newMessage
        oldMessage
    }
}