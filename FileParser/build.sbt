name := """FileParser"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "com.typesafe.akka" %% "akka-actor" % "2.3.11",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.11" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "com.google.protobuf" % "protobuf-java-util" % "3.0.0-beta-1",
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.5.0",
  "org.asynchttpclient" % "async-http-client" % "2.0.2",
  "com.h2database" % "h2" % "1.4.194",
  "org.avaje" % "ebean" % "2.7.3",
  "com.zaxxer" % "HikariCP" % "2.4.7"
)
