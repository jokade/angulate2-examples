
lazy val commonSettings = Seq(
  organization := "biz.enef",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.6",
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-language:implicitConversions","-Xlint"),
  libraryDependencies += "biz.enef" %%% "angulate2" % "0.1-SNAPSHOT",
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full),
  resolvers += Resolver.sonatypeRepo("snapshots"),
  publish := {},
  publishLocal := {} 
)

lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin).
  aggregate(firstApp, displayData, userInput).
  settings(commonSettings:_*)
  
lazy val firstApp = project.in(file("01_firstApp")).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings:_*)

lazy val displayData = project.in(file("02_displayData")).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings:_*)

lazy val userInput = project.in(file("03_userInput")).
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings:_*)
