package edu.trinity.videoquizreact

import slinky.core.annotations.react
import slinky.core.Component
import models.OneMessage
import models.ReadsAndWrites._
import slinky.core.facade.ReactElement
import slinky.web.html._
import org.scalajs.dom.document
import org.scalajs.dom.html

@react class MessageBoard extends Component {

  case class Props(doLogout: () => Unit)
  case class State(newMessage: String, oldMessage: String)

  val csrfToken = document.getElementById("csrfToken").asInstanceOf[html.Input].value
  val messageRoute = document.getElementById("messageRoute").asInstanceOf[html.Input].value
//   val deleteRoute = document.getElementById("deleteRoute").asInstanceOf[html.Input].value
  val addRoute = document.getElementById("addRoute").asInstanceOf[html.Input].value
  val logoutRoute = document.getElementById("logoutRoute").asInstanceOf[html.Input].value
  implicit val ec = scala.concurrent.ExecutionContext.global

  def initialState: State = State(Nil, "", "")

  override def componentDidMount(): Unit = {
    loadMessage()
  }

  def render(): ReactElement = div (
    ul (
      li (state.newMessage)
    ),
    br (),
    input (`type` := "text", value := state.newMessage, 
      onChange := (e => setState(state.copy(newMessage = e.target.value)))),
    button ("Add Message", onClick := (e => addMessage())),
    br(),
    button ("Logout", onClick := (e => logout())),
    state.oldMessage
  )

  def addMessage(): Unit = {
    FetchJson.fetchPost(addRoute, csrfToken, state.newMessage, (bool: Boolean) => {
      if(bool) {
        setState(state.copy(newMessage = "", oldMessage = ""))
        loadMessage()
      } else {
        setState(state.copy(oldMessage = "Failed to add."))
      }
    }, e => {
      println("Fetch error: " + e)
    })
  }

    def loadMessage(): Unit = {
        FetchJson.fetchGet(messageRoute, (message: Message) => {
        setState(state.copy(newMessage = message))
        }, e => {
        println("Fetch error: " + e)
        })
    }

}
