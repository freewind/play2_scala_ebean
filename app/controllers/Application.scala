package controllers

import models._
import play.api._
import play.api.mvc._
import play.api.data._
import Forms._
import scala.collection.JavaConversions._

object Application extends Controller {

  def index = Action {
    val questions = Question.find.findList()
    Ok(views.html.index(questions))
  }

}
