lazy val baseSettings: Seq[Setting[_]] = Seq(
  scalaVersion in ThisBuild := "2.11.8",
  libraryDependencies ++= Seq(
    "com.typesafe.play"    %% "play"       % "2.5.12",
    "org.scalatest"        %% "scalatest"  % "3.0.1" % "test"
  ),
  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding",
    "UTF-8",
    "-feature",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:existentials",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Xfuture"
  ),
  resolvers += Resolver
    .sonatypeRepo("releases")
)

lazy val rollYourOwnTypeclass =
  project
    .in(file("."))
    .settings(moduleName := "roll-your-own-typeclass")
    .settings(baseSettings: _*)
    .aggregate(core, slides)
    .dependsOn(core, slides)

lazy val core = project
  .settings(moduleName := "roll-your-own-typeclass-core")
  .settings(baseSettings: _*)

lazy val slides = project
  .settings(moduleName := "roll-your-own-typeclass-slides")
  .settings(baseSettings: _*)
  .settings(tutSettings: _*)
  .settings(
    tutSourceDirectory := baseDirectory.value / "tut",
    tutTargetDirectory := baseDirectory.value / "tut-out"
  )
  .dependsOn(core)
