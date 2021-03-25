package actors

import akka.actor.Actor
import akka.actor.Props
import model.CountModel
import CountActor._import java.net.Socket
import java.io.BufferedReader
import java.io.PrintStream
import akka.actor.ActorRef

class UserManager extends Actor{

    import UserManager._

    def receive {
        case NewUser(user) => context.actorOf(Props(new UserActor(),"Some ID Factor")
        case SendCount(ret) =>  ret ! RecieveCount(CountModel.getCount())
        case IncrementCount => CountModel.increaseCount()
        case m => out.print("Unhandled message in CountManager: " +m)
    }

}

object UserManager{

    case class NewUser(user: ActorRef)
    case class SendCount(ret: ActorRef)
    case class IncrementCount()
    
}