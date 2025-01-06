import kotlin.math.abs

fun main() {
    val input = generateSequence(::readLine)
    var s = 0
    for (line in input) {
        val levels = line.split("\\s+".toRegex()).map { it.toInt() }
        s += if (isSafe(levels)) 1 else 0
    }
    println(s)
}

fun isSafe(levels: List<Int>): Boolean {
    check(levels.size > 2)
    var prev = 0
    for (i in 0..<levels.size-1) {
        val delta = levels[i+1] - levels[i]
        if (abs(delta) < 1 || abs(delta) > 3) {
            return false
        }
        if (prev != 0 && (prev > 0) != (delta > 0)) {
            return false
        }
        prev = delta
    }
    return true
}