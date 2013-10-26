/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2013, Jonas Fonseca    **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \                               **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */

/*
 * Stubs for running benchmarks in d8.
 *
 * d8 is a tool included with V8: https://code.google.com/p/v8/
 */

this['console'] = {};
this['console']['log'] = this['print'];
