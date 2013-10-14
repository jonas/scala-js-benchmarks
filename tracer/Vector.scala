// The ray tracer code in this file is written by Adam Burmister. It
// is available in its original form from:
//
//   http://labs.flog.co.nz/raytracer/
//
// Ported from the v8 benchmark suite by Google 2012.
// Ported from the Dart benchmark_harness to Scala.js by Jonas Fonseca 2013
package benchmarks.tracer

class Vector(val x: Double, val y: Double, val z: Double) {

//  def copy(Vector v): Vector = {
//    this.x = v.x;
//    this.y = v.y;
//    this.z = v.z;
//  }

  def normalize: Vector = {
    val m = this.magnitude
    new Vector(x / m, y / m, z / m)
  }

  def magnitude: Double =
    math.sqrt((x * x) + (y * y) + (z * z))

  def cross(that: Vector): Vector = {
    new Vector(-this.z * that.y + this.y * that.z,
               this.z * that.x - this.x * that.z,
               -this.y * that.x + this.x * that.y)
  }

  def dot(that: Vector): Double =
    this.x * that.x + this.y * that.y + this.z * that.z

  def +(that: Vector): Vector =
    new Vector(that.x + x, that.y + y, that.z + z)

  def -(that: Vector): Vector =
    new Vector(x - that.x, y - that.y, z - that.z)

  def *(that: Vector): Vector =
    new Vector(x * that.x, y * that.y, z * that.z)

  def multiplyScalar(w: Double): Vector =
    new Vector(x * w, y * w, z * w)

  override def toString =
    s"Vector [$x, $y, $z]"
}
