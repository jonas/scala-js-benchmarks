/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2013, Jonas Fonseca    **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \                               **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */

/*
 * Export benchmarks to be run by common/start-benchmark.js.
 */

(function(ScalaJSBenchmarks) {
  ScalaJSBenchmarks['push'](function() {
    var benchmark = new ScalaJS.classes.benchmarks\ufe33richards\ufe33Richards();
    benchmark.report();
  });
})(this['ScalaJSBenchmarks'] || (this['ScalaJSBenchmarks'] = []))
