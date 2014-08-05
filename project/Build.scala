import sbt._
import Keys._

import com.github.retronym.SbtOneJar
import com.github.retronym.SbtOneJar.oneJar

object AkkaTestBuild extends Build {

  val projectDeps = Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.2.4",
    "ch.qos.logback" % "logback-core" % "1.0.13",
    "ch.qos.logback" % "logback-classic" % "1.0.13",
    "org.slf4j" % "slf4j-api" % "1.7.5" intransitive ()
  )

  val projSettings = SbtOneJar.oneJarSettings ++ Seq(
    scalaVersion := "2.10.2",
    compileOrder := CompileOrder.Mixed,
    mainClass in oneJar := Some("vj.akka.test.Main")
  )

  lazy val project: Project = Project(
    id = "akka-test",
    base = file("."),
    settings = Project.defaultSettings ++ projSettings ++ Seq(
      name := "akka-test",
      libraryDependencies ++= projectDeps
      //libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.2.4"
    ) 
  )
}
