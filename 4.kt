fun main() {
    val input = generateSequence(::readLine)
    val lines = input.toList()
    var result = 0
    lines.indices.flatMap { lines[it].indices.map { jt -> it to jt } }.forEach { pos ->
        result += xmasCount(lines, pos)
    }
    println(result)
}

const val XMAS = "XMAS"

// "horizontal, vertical, diagonal, written backwards, or even overlapping other words"
val steps = (-1..1).flatMap { (-1..1).map { jt -> it to jt } }
    .filter { (i, j) -> i != 0 || j != 0 }

fun xmasCount(lines: List<String>, pos: Pair<Int, Int>): Int {
    var result = 0
    for (step in steps) {
        result += if (isValidXmas(lines, pos, step)) 1 else 0
    }
    return result
}

fun isValidXmas(lines: List<String>, pos: Pair<Int, Int>, step: Pair<Int, Int>): Boolean {
    var pos = pos
    for (char in XMAS) {
        try {
            if (lines[pos.first][pos.second] != char) return false
        } catch (_: Exception) {
            return false
        }
        pos = (pos.first + step.first) to (pos.second + step.second)
    }
    return true
}
