package actors

import akka.actor.Actor
import akka.actor.Props
import java.net.Socket
import java.io.BufferedReader
import java.io.PrintStream
import akka.actor.ActorRef

class UserActor extends Actor {

    def receive{

        case RecieveCount => print("UserActor.RecieveCount(): " +count)
        case m => print("Unhandleded message in UserActor " +m)

    }

}

object UserActor{
    case class RecieveCount(count: Int)
}