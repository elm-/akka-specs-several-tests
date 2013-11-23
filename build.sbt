name := "simple-mongo-performance-test"

organization := "org.elmarweber"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.2"


resolvers ++= Seq(
  "typesafe repo" at "http://repo.typesafe.com/typesafe/releases/"
)


libraryDependencies ++= {
  val akkaVersion = "2.1.4"
  val specsVersion = "2.3.4"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
    "org.specs2" %% "specs2" % specsVersion % "test"
  )
}
