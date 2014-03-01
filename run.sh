#!/bin/sh

. "$(dirname "$0")/common/benchmark-runner.sh"

EXCLUDE=sudoku

detect_engines $ENGINES

for benchmark in $(find . -mindepth 2 -name "run.sh" | grep -vE "$EXCLUDE"); do
	name="$(basename "$(dirname "$benchmark")")"
	echo
	info "$name [dev] sbt"
	TIME="%E" time sbt "$name/packageJS" >/dev/null
	info "$name [opt] sbt"
	TIME="%E" time sbt "$name/optimizeJS" >/dev/null

	for mode in $MODES; do
		for engine in d8; do
			run_benchmark_mode "$engine" "$name" "$mode"
		done
	done
done
