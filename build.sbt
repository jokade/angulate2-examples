
lazy val commonSettings = Seq(
  organization := "de.surfice",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.6",
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-Xlint"
    //,"-Xmacro-settings:angulate2.debug.Component"
  ),
  resolvers += Resolver.sonatypeRepo("snapshots"),
  publish := {},
  publishLocal := {}
)

lazy val root = project.in(file(".")).
  enablePlugins(Angulate2Plugin).
  aggregate(firstApp, displayData, userInput, heroes).
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

lazy val heroes = project.in(file("04_heroes")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*)

lazy val todomvc = project.in(file("05_todomvc")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*)

lazy val server = project.
  settings(commonSettings:_*).
  settings(
    run in Compile <<= (run in Compile) dependsOn (
      fastOptJS in (firstApp,Compile),
      fastOptJS in (displayData,Compile),
      fastOptJS in (heroes,Compile),
      fastOptJS in (todomvc,Compile)
    ),
    libraryDependencies ++= Seq(
      "de.surfice" %% "surf-rest" % "0.1-SNAPSHOT"
    )
  )
