package controllers

import models._
import play.api._
import play.api.mvc._
import play.api.data._
import Forms._
import scala.collection.JavaConversions._

object Answers extends Controller {

  def answer(id: String) = Action { implicit connection =>
    Form("content" -> nonEmptyText).bindFromRequest.fold(
      errors => BadRequest,
      content => {
        val question = Question.find.byId(id.toLong)
        new Answer(content, question).save()
        Questions.redirectToShow(id.toLong)
      })
  }

  def delete(id: String) = Action {
    val answer = Answer.find.byId(id.toLong)
    answer.delete()
    Questions.redirectToShow(answer.question.id)
  }

  def clear(questionId: String) = Action {
    val question = Question.find.byId(questionId.toLong)
    question.answers.clear()
    question.update()
    Questions.redirectToShow(question.id)
  }

}
