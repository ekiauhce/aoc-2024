#!/bin/bash

set -uoe pipefail
IFS=$'\n\t'

TASK_ID="$1"

if [ -z "${2:-}" ]; then
    INPUT_ID="$TASK_ID"
else
    INPUT_ID="$2"
fi
INPUT_FILE="./$TASK_ID.txt"
if [ ! -e "$INPUT_FILE" ]; then
    curl "https://adventofcode.com/2024/day/$INPUT_ID/input" -H "Cookie: $(cat ~/.aoc-cookie)" -s > "$INPUT_FILE"
fi
kotlinc -include-runtime "$TASK_ID".kt -d "$TASK_ID".jar
java -jar "$TASK_ID".jar < "$INPUT_FILE"
