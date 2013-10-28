#!/bin/sh

. "$(dirname "$0")/common/benchmark-runner.sh"

info()
{
	printf "%-20s : " "$1"; shift
	test $# -gt 0 && echo "$@"
}

info "d8" "$(d8 -e 'print(version())') [$(which d8)]"
info "node" "$(node -v) [$(which node)]"

for benchmark in $(find . -mindepth 2 -name "run.sh"); do
	name="$(basename "$(dirname "$benchmark")")"
	echo
	info "$name [dev] sbt"
	TIME="%E" time sbt "$name/packageJS" >/dev/null
	info "$name [opt] sbt"
	TIME="%E" time sbt "$name/optimizeJS" >/dev/null

	for mode in dev opt js; do
		for engine in d8 node; do
			info "$name [$mode] $engine" 
			"$name/run.sh" "$engine" "$mode" | sed 's/[^:]*:\s//'
		done
	done
done
