
lazy val commonSettings = Seq(
  organization := "de.surfice",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.6",
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-Xlint"
    //,"-Xmacro-settings:angulate2.debug.Component"
    //,"-Xmacro-settings:angulate2.debug.Data"
  ),
  resolvers += Resolver.sonatypeRepo("snapshots"),
  publish := {},
  publishLocal := {}
)

lazy val root = project.in(file(".")).
  enablePlugins(Angulate2Plugin).
  aggregate(firstApp, displayData, userInput, heroes, angelloLiteJVM, angelloLiteJS, router).
  settings(commonSettings:_*).
  settings(
    name := "angulate2-examples"
  )
  
lazy val firstApp = project.in(file("01_firstApp")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*)

lazy val displayData = project.in(file("02_displayData")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*)

lazy val userInput = project.in(file("03_userInput")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*)

lazy val heroes = project.in(file("04_heroes")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*)

lazy val todomvc = project.in(file("05_todomvc")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*)

lazy val angelloLite = crossProject.in(file("06_angelloLite"))
  .settings(commonSettings:_*)
  .jsConfigure(_.enablePlugins(Angulate2Plugin))
  .jsSettings(
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      "de.surfice" %% "surf-rest" % "0.1-SNAPSHOT",
      "de.surfice" %% "angulate2-stubs" % "0.1-SNAPSHOT"
    )
  )

lazy val angelloLiteJVM = angelloLite.jvm
lazy val angelloLiteJS = angelloLite.js


lazy val router = project.in(file("07_router")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*)


lazy val server = project.
  dependsOn(angelloLiteJVM).
  settings(commonSettings:_*).
  settings(
    run in Compile <<= (run in Compile) dependsOn (
      fastOptJS in (firstApp,Compile),
      fastOptJS in (displayData,Compile),
      fastOptJS in (userInput,Compile),
      fastOptJS in (heroes,Compile),
      fastOptJS in (todomvc,Compile),
      fastOptJS in (angelloLiteJS,Compile),
      fastOptJS in (router,Compile)
    ),
    libraryDependencies ++= Seq(
      "de.surfice" %% "surf-rest" % "0.1-SNAPSHOT"
    )
  )
