package example

import org.scalajs.dom
import org.scalajs.dom.document
import scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.html
import slinky.web.ReactDOM
import slinky.web.html._

object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello World.")
    for (i <- 1 to 10) println(i)
  }
}