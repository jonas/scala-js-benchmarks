/* Scala.js benchmark
 * Public domain
 * Author: Jonas Fonseca
 */

if (typeof(this['__scalajs_benchmarks_global']) === 'object') {
	ScalaJS.g = this['__scalajs_benchmarks_global'];
}

(function(ScalaJSBenchmarks) {
  ScalaJSBenchmarks['push'](function() {
    var benchmark = new ScalaJS.classes.benchmarks\ufe33tracer\ufe33Tracer();
    benchmark.report();
  });

  ScalaJSBenchmarks['startApp'] = function() {
    var app = new ScalaJS.classes.benchmarks\ufe33tracer\ufe33App();
    app.init();
  };
})(this['ScalaJSBenchmarks'] || (this['ScalaJSBenchmarks'] = []))
