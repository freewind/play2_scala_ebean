import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

  val appName = "play2_scala_ebean"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    // "commons-io" % "commons-io" % "2.1",
    "org.scalatest" %% "scalatest" % "1.7.RC2" % "test")

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    // Add your own project settings here
    // scalatest will work if we add the following line
    ebeanEnabled := true,
    testOptions in Test := Nil)

}
