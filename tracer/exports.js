/* Scala.js benchmark
 * Public domain
 * Author: Jonas Fonseca
 */

// Guard against minification.
var Tracer = this['Tracer'] || {};
this['Tracer'] = Tracer;

Tracer['startApp'] = function() {
  var app = new ScalaJS.classes.benchmarks\ufe33tracer\ufe33App();
  app.init();
};

Tracer['startBenchmark'] = function() {
  var benchmark = new ScalaJS.classes.benchmarks\ufe33tracer\ufe33Tracer();
  benchmark.report();
};
