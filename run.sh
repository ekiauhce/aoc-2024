#!/bin/bash

set -uoe pipefail
IFS=$'\n\t'

ID="$1"
INPUT_FILE="./$ID.txt"
if [ ! -e "$INPUT_FILE" ]; then
    curl "https://adventofcode.com/2024/day/$ID/input" -H "Cookie: $(cat ~/.aoc-cookie)" -s > "$INPUT_FILE"
fi
kotlinc -include-runtime "$ID".kt -d "$ID".jar
java -jar "$ID".jar < "$INPUT_FILE"
