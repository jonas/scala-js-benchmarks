/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  Adam Burmister             **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \    2012, Google, Inc          **
** /____/\___/_/ |_/____/_/ | |__/ /____/    2013, Jonas Fonseca        **
**                          |/____/                                     **
\*                                                                      */

// The ray tracer code in this file is written by Adam Burmister. It
// is available in its original form from:
//
//   http://labs.flog.co.nz/raytracer/
//
// Ported from the v8 benchmark suite by Google 2012.
// Ported from the Dart benchmark_harness to Scala.js by Jonas Fonseca 2013

package org.scalajs.benchmark.tracer

import scala.scalajs.js.annotation.JSExport

@JSExport
object Tracer extends org.scalajs.benchmark.Benchmark with App {

  val config = EngineConfiguration(
    imageWidth = 100,
    imageHeight = 100,
    pixelWidth = 5,
    pixelHeight = 5,
    rayDepth = 2,
    renderDiffuse = true,
    renderShadows = true,
    renderHighlights = true,
    renderReflections = true
  )

  override def prefix = "Tracer"

  def run {
    new RenderScene().renderScene(config, null)
  }

}
