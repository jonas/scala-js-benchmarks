#!/bin/sh

# d8 is a tool included with V8:
# https://code.google.com/p/v8/

RUN_DIR="$(dirname "$0")"
OUT_DIR="$RUN_DIR/target/scala-2.10"

case "$1" in
opt)
	d8 "$OUT_DIR/tracer-opt.js" \
	   "$RUN_DIR/start-benchmark.js"
	;;
dev)
	d8 "$OUT_DIR/tracer-extdeps.js" \
	   "$OUT_DIR/tracer-intdeps.js" \
	   "$OUT_DIR/tracer.js" \
	   "$RUN_DIR/start-benchmark.js"
	;;
*)
	echo "Usage: $0 [opt|dev]"
esac
