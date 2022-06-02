ThisBuild / scalaVersion := "3.1.2"
ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "zio-http4s-fiber-death",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.0.0-RC6",
      "dev.zio" %% "zio-interop-cats" % "3.3.0-RC7",
      "org.http4s" %% "http4s-ember-server" % "0.23.12",
      "org.http4s" %% "http4s-dsl" % "0.23.12",
      "ch.qos.logback" % "logback-classic" % "1.2.7"
    )
  )
