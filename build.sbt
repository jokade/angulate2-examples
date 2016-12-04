
lazy val commonSettings = Seq(
  organization := "de.surfice",
  version := "0.0.1",
  scalaVersion := "2.11.8",
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-Xlint"),
  resolvers += Resolver.sonatypeRepo("snapshots"),
  publish := {},
  publishLocal := {},
  libraryDependencies ++= Seq(
  ),
  scalacOptions ++= (if (isSnapshot.value) Seq.empty else Seq({
        val a = baseDirectory.value.toURI.toString.replaceFirst("[^/]+/?$", "")
        val g = "https://raw.githubusercontent.com/jokade/angulate2-examples"
        s"-P:scalajs:mapSourceURI:$a->$g/v${version.value}/"
      }))
)

lazy val root = project.in(file("."))
  .aggregate(heroes)
  .settings(commonSettings: _*)
  .settings(
    name := "angulate2-examples"
  )

lazy val heroes = project
  .enablePlugins(Angulate2Plugin)
  .settings(commonSettings: _*)
  .settings( 
    name := "heroes",
    libraryDependencies ++= Seq(
    ),
    ngBootstrap := Some("heroes.AppModule")
  )


