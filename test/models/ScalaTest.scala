package models

import org.junit.runner.RunWith
import org.scalatest.matchers._
import org.scalatest._
import org.scalatest.junit.JUnitRunner

import play.api.Play.current
import play.api.db.DB

import play.api.test.Helpers._
import play.api.test.FakeApplication
import models._

@RunWith(classOf[JUnitRunner])
class ScalaTest extends FlatSpec with ShouldMatchers {

  protected def fakeApp = FakeApplication(additionalConfiguration = Map())

//  "Users" should "be queried" in {
//    running(fakeApp) {
//      val users = User.find.where().findList()
//      println(users.size())
//    }
//  }

}
