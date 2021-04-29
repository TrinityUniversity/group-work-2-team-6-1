package models

object OneMessage{

    private val author: String = ""
    private val message: String = ""

    def receiveMessage(newMessage: String): String = {
        val oldMessage = message
        message = newMessage
        oldMessage
    }

}