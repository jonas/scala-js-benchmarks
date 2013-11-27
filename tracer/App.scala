/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2013, Jonas Fonseca    **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \                               **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */

package benchmarks.tracer

import scala.scalajs.js

class App {
  def init() {
    val button = $("render")

    button.onclick = renderScene _
  }

  def renderScene() {
    val config = new EngineConfiguration(
      imageWidth = int("imageWidth"),
      imageHeight = int("imageHeight"),
      pixelWidth = int("pixelSize"),
      pixelHeight = int("pixelSize"),
      rayDepth = 2,
      renderDiffuse = bool("renderDiffuse"),
      renderShadows = bool("renderShadows"),
      renderHighlights = bool("renderHighlights"),
      renderReflections = bool("renderReflections")
    )

    val canvas = $("canvasContext").asInstanceOf[HTMLCanvasElement]
    canvas.width = config.imageWidth
    canvas.height = config.imageHeight
    val canvasContext = canvas.getContext("2d").asInstanceOf[CanvasRenderingContext2D]

    var before = new js.Date()
    new RenderScene().renderScene(config, canvasContext)
    var after = new js.Date()
    val elapsedTime = after.getTime() - before.getTime()
    $("time").innerHTML = elapsedTime.toString(10)
  }

  def $(id: String): DOMElement =
    js.Dynamic.global.document.getElementById(id).asInstanceOf[DOMElement]

  def int(id: String): Int =
    js.parseInt($(id).asInstanceOf[HTMLInputElement].value).toInt

  def bool(id: String): Boolean =
    $(id).asInstanceOf[HTMLCheckboxElement].checked.toString == "true"
}
