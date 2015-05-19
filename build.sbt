
lazy val commonSettings = Seq(
  organization := "biz.enef",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.6",
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-Xlint"),
  libraryDependencies += "biz.enef" %%% "angulate2" % "0.1-SNAPSHOT",
  resolvers += Resolver.sonatypeRepo("snapshots"),
  publish := {},
  publishLocal := {} 
)

lazy val root = project.in(file(".")).
  aggregate(firstApp, displayData, userInput).
  settings(commonSettings:_*)
  
lazy val firstApp = project.in(file("01_firstApp")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*)

lazy val displayData = project.in(file("02_displayData")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*)

lazy val userInput = project.in(file("03_userInput")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*)

