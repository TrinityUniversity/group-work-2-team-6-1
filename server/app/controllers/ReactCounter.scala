package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._

import models.CountModel

@Singleton
class ReactCounter @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action { implicit request =>
      Ok(views.html.reactCounter())
  }
  

  def add = Action { implicit request =>
      CountModel.increaseCount()
      Ok(Json.toJson(CountModel.getCount()))
  }

  def getCount = Action { implicit request =>
    Ok(Json.toJson(CountModel.getCount()))
  }

}
