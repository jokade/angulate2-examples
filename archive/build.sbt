//import Angulate2Plugin._

lazy val commonSettings = Seq(
  organization := "de.surfice",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.8",
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
  aggregate(firstApp, displayData, userInput, heroes, angelloLiteJVM, angelloLiteJS, router, bootstrap).
  settings(commonSettings:_*).
  settings(
    name := "angulate2-examples"
  )
  
lazy val firstApp = project.in(file("01_firstApp")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*).
  settings(
    jsDependencies ++= Seq(
      "org.webjars.npm" % "angular__core" % "2.0.0-rc.2" / "bundles/core.umd.min.js",
      "org.webjars.npm" % "angular__common" % "2.0.0-rc.2" / "bundles/common.umd.min.js" dependsOn "bundles/core.umd.min.js",
      "org.webjars.npm" % "angular__http" % "2.0.0-rc.2" / "bundles/http.umd.min.js" dependsOn "bundles/core.umd.min.js",
      "org.webjars.npm" % "angular__platform-browser" % "2.0.0-rc.2" / "bundles/platform-browser.umd.min.js" dependsOn "bundles/common.umd.min.js",
      "org.webjars.npm" % "github-com-angular-platform-browser-dynamic-builds" % "0.0.0-PLACEHOLDER" / "bundles/platform-browser-dynamic.umd.min.js" dependsOn "bundles/platform-browser.umd.min.js",
      "org.webjars.npm" % "angular__compiler" % "2.0.0-rc.2" / "bundles/compiler.umd.min.js" dependsOn "bundles/common.umd.min.js"
      ),
    ngBootstrap := Some("FirstApp")
  )

lazy val displayData = project.in(file("02_displayData")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*).
  settings(
    ngBootstrap := Some("DisplayApp")
  )

lazy val userInput = project.in(file("03_userInput")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*).
  settings(
    ngBootstrap := Some("TodoList")
  )

lazy val heroes = project.in(file("04_heroes")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*).
  settings(
    ngBootstrap := Some("HeroesApp")
  )

lazy val todomvc = project.in(file("05_todomvc")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*).
  settings(
    ngBootstrap := Some("TodoApp")
  )

lazy val angelloLite = crossProject.in(file("06_angelloLite"))
  .enablePlugins(Angulate2Plugin)
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
  settings(commonSettings:_*).
  settings(
    sjsxLoader := SJSXLoader.SystemJS,
    sjsxDeps ++= Seq(
      SJSXDependency("ng.router","angular2/router")
    ),
    ngBootstrap := Some("router.AppComponent")
  )


lazy val bootstrap = project.in(file("08_bootstrap")).
  enablePlugins(Angulate2Plugin).
  settings(commonSettings:_*).
  settings(
    sjsxLoader := SJSXLoader.SystemJS,
    ngBootstrap := Some("bootstrap.AppComponent"),
    jsDependencies ++= Seq(
  //    "org.webjars.npm" % "ng2-bootstrap" % "1.0.16" / "bundles/ng2-bootstrap.min.js",
    //  "org.webjars.bower" % "system.js" % "0.19.17" / "dist/system-register-only.js"
    )
  )


lazy val server = project.
  //dependsOn(angelloLiteJVM).
  settings(commonSettings:_*).
  settings(
    run in Compile <<= (run in Compile) dependsOn (
      fastOptJS in (firstApp,Compile),
      fastOptJS in (displayData,Compile),
      fastOptJS in (userInput,Compile),
      fastOptJS in (heroes,Compile),
      fastOptJS in (todomvc,Compile)
      //fastOptJS in (angelloLiteJS,Compile)
      // fastOptJS in (router,Compile),
      // fastOptJS in (bootstrap,Compile)
    ),
    libraryDependencies ++= Seq(
      "de.surfice" %% "surf-rest" % "0.1-SNAPSHOT"
    )
  )
