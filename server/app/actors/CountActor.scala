package actors

import akka.actor._
import model.CountModel
import actors.CountActor._

class CountActor() extends Actor {

    def receive = {
        case SendCount =>  other ! RecieveCount(CountModel.getCount())
        case RecieveCount => count
        case IncrementCount => CountModel.increaseCount()
        case e => out.println("Unhandled message in CountActor: " + e)
    }
}

object CountActor() {
    case class SendCount(other: ActorRef)
    case class IncrementCount()
}