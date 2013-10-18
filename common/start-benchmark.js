/*
 * Scala.js Benchmarks - Run one or more benchmarks.
 * Author: Jonas Fonseca
 */

this['console'] = {};
this['console']['log'] = print;

(this['ScalaJSBenchmarks'] || []).forEach(function(benchmark) {
  benchmark();
});
