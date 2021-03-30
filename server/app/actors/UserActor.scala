package actors

import akka.actor.Actor
import akka.actor.Props
import java.net.Socket
import java.io.BufferedReader
import java.io.PrintStream
import akka.actor.ActorRef

class UserActor extends Actor {

    import UserActor._
    def receive = {
        case RecieveCount(count) => println("UserActor.RecieveCount(): " +count)
        case m => println("Unhandleded message in UserActor " +m)
    }

}

object UserActor{
    case class RecieveCount(count: Int)
}