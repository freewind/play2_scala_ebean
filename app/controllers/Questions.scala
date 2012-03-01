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

  def show(id: Long) = Action {
    val question = Question.find.byId(id)
    Ok(views.html.questions.show(question))
  }

  def delete(id: Long) = Action {
    Question.find.byId(id).delete()
    Redirect(routes.Application.index())
  }

  def edit(id: Long) = Action {
    val question = Question.find.byId(id)
    Ok(views.html.questions.edit(question))
  }

  def update(id: Long) = Action { implicit request =>
    Form(tuple("title" -> nonEmptyText, "content" -> nonEmptyText)).bindFromRequest.fold(errors => BadRequest, params => params match {
      case (title, content) => {
        val question = Question.find.byId(id)
        // FIXME 只有setter才能改变值
        question.setTitle(title)
        // 直接给字段赋值不行。因为play不会对scala文件进行替换
        question.content = content
        question.update()
        redirectToShow(question.id)
      }
    })

  }

  def redirectToShow(id: Long) = {
    Redirect(routes.Questions.show(id))
  }

}
