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
	     clean in deltablue,
	     clean in richards,
	     clean in tracer
	  ).value
      )
  ).aggregate(
      common,
      deltablue,
      richards,
      tracer
  )

  lazy val common = project("Common", defaultSettings)
  lazy val deltablue = project("DeltaBlue", benchmarkSettings).dependsOn(common)
  lazy val richards = project("Richards", benchmarkSettings).dependsOn(common)
  lazy val tracer = project("Tracer", benchmarkSettings).dependsOn(common)

  def project(id: String, settings: Seq[sbt.Def.Setting[_]]) = Project(
      id = id.toLowerCase,
      base = file(id.toLowerCase),
      settings = settings ++ Seq(
          name := s"$id - Scala.js Benchmark",
          moduleName := id.toLowerCase
      )
  )
}
