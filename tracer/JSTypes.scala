/* Scala.js example code
 * Public domain
 * @author  Sébastien Doeraene
 */

package benchmarks.tracer

import scala.js

trait DOMElement extends js.Object {
  var innerHTML: js.String

  def appendChild(child: DOMElement): Unit
  var onclick: js.Function0[_]
}

trait HTMLInputElement extends js.Object {
  var value: js.String
}

trait HTMLCheckboxElement extends js.Object {
  var checked: js.Boolean
}

trait HTMLCanvasElement extends DOMElement {
  def getContext(kind: js.String): js.Any // depends on the kind
  var width: js.Number
  var height: js.Number
}

trait CanvasRenderingContext2D extends js.Object {
  val canvas: HTMLCanvasElement

  var fillStyle: js.String
  var lineWidth: js.Number

  def fillRect(x: js.Number, y: js.Number, w: js.Number, h: js.Number)
  def strokeRect(x: js.Number, y: js.Number, w: js.Number, h: js.Number)

  def beginPath()
  def fill()
  def stroke()

  def arc(x: js.Number, y: js.Number, radius: js.Number,
      startAngle: js.Number, endAngle: js.Number, anticlockwise: js.Boolean)
}
