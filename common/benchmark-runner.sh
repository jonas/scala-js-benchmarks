#!/bin/sh
#
# Run a benchmark against a JavaScript VM.

# set -x

RUN_DIR="$(dirname "$0")"
OUT_DIR="$RUN_DIR/target/scala-2.10"
LIB_DIR="$(dirname "$0")/../common"
BENCHMARK="$(basename "$(cd "$RUN_DIR" && pwd)")"

runner="d8_runner"
mode="dev"

while test $# != 0; do
	arg="$1"; shift

	case "$arg" in
	dev|opt) mode="$arg" ;;
	d8|node) runner="${arg}_runner"
	esac
done

d8_runner()
{
	d8 "$LIB_DIR/d8-stubs.js" "$@"
}

node_runner()
{
	js="$OUT_DIR/$BENCHMARK.node.js"
	cat "$@" > "$js"
	node "$js"
}

run_benchmark()
{
	case "$mode" in
	opt)
		$runner "$OUT_DIR/$BENCHMARK-opt.js" \
			"$LIB_DIR/start-benchmark.js"
		;;
	dev)
		$runner "$OUT_DIR/$BENCHMARK-extdeps.js" \
			"$OUT_DIR/$BENCHMARK-intdeps.js" \
			"$OUT_DIR/$BENCHMARK.js" \
			"$LIB_DIR/start-benchmark.js"
		;;
	*)
		echo "Usage: $0 [d8|node] [dev|opt]"
	esac
}
