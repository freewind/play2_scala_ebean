package controllers

import models._
import play.api._
import play.api.mvc._
import play.api.data._
import Forms._
import scala.collection.JavaConversions._

object Questions extends Controller {

  def ask = Action {
    Ok(views.html.questions.ask())
  }

  def create = Action { implicit request =>
    Form(tuple("title" -> nonEmptyText, "content" -> nonEmptyText)).bindFromRequest.fold(
      errors => BadRequest,
      params => params match {
        case (title, content) => {
          new Question(title, content).save()
          Redirect(routes.Application.index())
        }
      })
  }

  def show(id: String) = Action {
    val question = Question.find.byId(id.toLong)
    Ok(views.html.questions.show(question))
  }

  def delete(id: String) = Action {
    Question.find.byId(id.toLong).delete()
    Redirect(routes.Application.index())
  }

  def edit(id: String) = Action {
    val question = Question.find.byId(id.toLong)
    Ok(views.html.questions.edit(question))
  }

  def update(id: String) = Action { implicit request =>
    Form(tuple("title" -> nonEmptyText, "content" -> nonEmptyText)).bindFromRequest.fold(errors => BadRequest, params => params match {
      case (title, content) => {
        val question = Question.find.byId(id.toLong)
        question.title = title;
        question.content = content;
        question.update()
        redirectToShow(question.id)
      }
    })

  }

  def redirectToShow(id: Long) = {
    Redirect(routes.Questions.show(id.toString))
  }

}
