#!/bin/sh

# d8 is a tool included with V8:
# https://code.google.com/p/v8/

# set -x

RUN_DIR="$(dirname "$0")"
OUT_DIR="$RUN_DIR/target/scala-2.10"
BENCHMARK="$(basename "$(cd "$RUN_DIR" && pwd)")"

run_benchmark()
{
	case "$1" in
	opt)
		d8 "$OUT_DIR/$BENCHMARK-opt.js" \
			"$RUN_DIR/../common/start-benchmark.js"
		;;
	dev)
		d8 "$OUT_DIR/$BENCHMARK-extdeps.js" \
			"$OUT_DIR/$BENCHMARK-intdeps.js" \
			"$OUT_DIR/$BENCHMARK.js" \
			"$RUN_DIR/../common/start-benchmark.js"
		;;
	*)
		echo "Usage: $0 [opt|dev]"
	esac
}
