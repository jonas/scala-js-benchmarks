#!/bin/sh
#                     __
#     ________ ___   / /  ___      __ ____  Scala.js Benchmarks
#    / __/ __// _ | / /  / _ | __ / // __/  (c) 2013, Jonas Fonseca
#  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \
# /____/\___/_/ |_/____/_/ | |__/ /____/
#                          |/____/
#

# Run a benchmark against a JavaScript VM.

# set -x

RUN_DIR="$(dirname "$0")"
OUT_DIR="$RUN_DIR/target/scala-2.10"
LIB_DIR="$(dirname "$0")/../common"
BENCHMARK="$(basename "$(cd "$RUN_DIR" && pwd)")"

runner=""
engine="d8"
mode="dev"

die() {
	echo >&2 "$@"
	exit 1
}

while test $# != 0; do
	arg="$1"; shift

	case "$arg" in
	dev|opt|js) mode="$arg" ;;
	d8) engine="${arg}" ;;
	node) engine="${arg}" runner="${arg}_runner" ;;
	esac
done

test -z "$runner" && runner="$engine"

node_runner()
{
	js="$OUT_DIR/$BENCHMARK.node.js"
	cat "$@" > "$js"
	node "$js"
}

run_benchmark()
{
	case "$mode" in
	js)
		$runner "$LIB_DIR/$engine-stubs.js" \
			"$LIB_DIR/reference/bench.js" \
			"$LIB_DIR/reference/$BENCHMARK.js" \
			"$LIB_DIR/start-benchmark.js"
		;;
	opt)
		$runner "$LIB_DIR/$engine-stubs.js" \
			"$OUT_DIR/$BENCHMARK-opt.js" \
			"$LIB_DIR/start-benchmark.js"
		;;
	dev)
		$runner "$LIB_DIR/$engine-stubs.js" \
			"$OUT_DIR/$BENCHMARK-extdeps.js" \
			"$OUT_DIR/$BENCHMARK-intdeps.js" \
			"$OUT_DIR/$BENCHMARK.js" \
			"$LIB_DIR/start-benchmark.js"
		;;
	*)
		echo "Usage: $0 [d8|node] [dev|opt|js]"
	esac
}
