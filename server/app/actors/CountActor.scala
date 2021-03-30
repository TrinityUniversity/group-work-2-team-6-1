package actors

import akka.actor._
import models.CountModel
import actors.CountActor._

class CountActor() extends Actor {

    def receive = {
        case SendCount(other) =>  other ! RecieveCount(CountModel.getCount())
        case RecieveCount(count) => count
        case IncrementCount => CountModel.increaseCount()
        case e => println("Unhandled message in CountActor: " + e)
    }
}

object CountActor {
    case class SendCount(other: ActorRef)
    case class RecieveCount(count: Int)
    case class IncrementCount()
}