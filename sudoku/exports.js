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

// FIXME: Needed for scala.util.Try. Move to Scala.js
ScalaJS.is.java_lang_StackOverflowError = function() { return false; };
ScalaJS.is.java_lang_VirtualMachineError = function() { return false; };
ScalaJS.is.java_lang_ThreadDeath = function() { return false; };
ScalaJS.is.java_lang_InterruptedException = function() { return false; };
ScalaJS.is.java_lang_LinkageError = function() { return false; };

(function(ScalaJSBenchmarks) {
  ScalaJSBenchmarks['push'](function() {
    var benchmark = new ScalaJS.classes.benchmarks_sudoku_Sudoku();
    benchmark.report();
  });
})(this['ScalaJSBenchmarks'] || (this['ScalaJSBenchmarks'] = []))
