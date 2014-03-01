/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2013, Jonas Fonseca    **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \                               **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */

/*
 * Run one or more benchmarks.
 */

DeltaBlue().runBenchmark();
//DeltaBlue().report();

//var globalScope = (typeof global === 'object') ? global : this;
//globalScope['runScalaJSBenchmarks']();

Benchmark().runBenchmarks();

if (typeof phantom === 'object') {
  phantom.exit();
}
