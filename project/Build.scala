import sbt._
import Keys._

import ch.epfl.lamp.sbtscalajs._
import ScalaJSPlugin._
import ScalaJSKeys._

object ScalaJSBuild extends Build {

  val scalajsScalaVersion = "2.10.2"

  val projectSettings = Defaults.defaultSettings ++ Seq(
      organization := "scalajs-benchmarks",
      version := "0.1-SNAPSHOT"
  )

  val defaultSettings = projectSettings ++ scalaJSSettings ++ Seq(
      scalaVersion := scalajsScalaVersion,
      scalacOptions ++= Seq(
          "-deprecation",
          "-unchecked",
          "-feature",
          "-encoding", "utf8"
      )
  )

  lazy val benchmarkSettings = defaultSettings ++ Seq(
      unmanagedSources in (Compile, packageJS) +=
          baseDirectory.value / "exports.js"
  )

  lazy val parent: Project = Project(
      id = "parent",
      base = file("."),
      settings = projectSettings ++ Seq(
          name := "Scala.js Benchmarks",
          publishArtifact in Compile := false,

          clean := clean.dependsOn(
	     clean in common,
	     clean in tracer
	  ).value
      )
  ).aggregate(
      common,
      tracer
  )

  lazy val common = Project(
      id = "common",
      base = file("common"),
      settings = defaultSettings ++ Seq(
          name := "Common - Scala.js Benchmark",
          moduleName := "common"
      )
  )

  lazy val tracer = Project(
      id = "tracer",
      base = file("tracer"),
      settings = benchmarkSettings ++ Seq(
          name := "Tracer - Scala.js Benchmark",
          moduleName := "tracer"
      )
  ).dependsOn(common)
}
