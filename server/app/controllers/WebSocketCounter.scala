package contro

import javax.inject._
import play.api.mvc._
import play.api.i18n._
import models.CountModel
import play.api.libs.json._
import akka.actor.Actor
import play.api.libs.streams.ActorFlow
import akka.actor.ActorSystem
import akka.stream.Materializer
import actors.CountActor
import akka.actor.Props
import akka.actor.ActorRef

@Singleton
class WebSocketCounter @Inject() (cc: ControllerComponents)(implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {
  
  //val userManager = system.actorOf(Props[UserManager], "User Manager")
  
  /* def counter = Action { 
      Ok(views.html.counter(actorRef ! SendCount(This)))
  } */

  /* def getSocket = WebSocket.accept[???] { request =>
    ActorFlow.actorRef{ out => 
        
    }
  } */
} 