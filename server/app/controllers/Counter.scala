package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._

import models._
import actors._
import akka.actor._

@Singleton
class Counter @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def counter = Action{
      Ok(views.html.counter(CountModel.getCount()))
  }
  
  def add = Action {
      CountModel.increaseCount()
      Ok(Json.toJson(CountModel.getCount()))
  }

}
