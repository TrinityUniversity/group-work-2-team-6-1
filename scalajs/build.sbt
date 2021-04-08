import Dependencies._

ThisBuild / scalaVersion     := "2.12.11"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "edu.trinity"
ThisBuild / organizationName := "Trinity"


lazy val root = (project in file("."))
  .settings(
    name := "ScalaJS-only",
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full),
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0",
    libraryDependencies += "me.shadaj" %%% "slinky-core" % "0.6.5",
		libraryDependencies += "me.shadaj" %%% "slinky-web" % "0.6.5",
    libraryDependencies += scalaTest % Test,
		scalaJSUseMainModuleInitializer := true
  ).enablePlugins(ScalaJSPlugin)