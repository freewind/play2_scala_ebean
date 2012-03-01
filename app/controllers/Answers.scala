package controllers

import models._
import play.api._
import play.api.mvc._
import play.api.data._
import Forms._
import scala.collection.JavaConversions._

object Answers extends Controller {

  def answer(id: Long) = Action { implicit connection =>
    Form("content" -> nonEmptyText).bindFromRequest.fold(
      errors => BadRequest,
      content => {
        val question = Question.find.byId(id)
        new Answer(content, question).save()
        Questions.redirectToShow(id)
      })
  }

  def delete(id: Long) = Action {
    val answer = Answer.find.byId(id)
    answer.delete()
    Questions.redirectToShow(answer.question.id)
  }

  def clear(questionId: Long) = Action {
    val question = Question.find.byId(questionId)
    question.answers.toList foreach { answer =>
      question.answers.remove(answer)
    }
    question.save()
    Questions.redirectToShow(question.id)
  }

}
