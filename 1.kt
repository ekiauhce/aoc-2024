import kotlin.math.abs

fun main() {
    val input = generateSequence(::readLine)

    val left = ArrayList<Int>()
    val right = ArrayList<Int>()
    for (line in input) {
        val (l, r) = line.split("\\s+".toRegex()).map { it.toInt() }
        left.add(l)
        right.add(r)
    }
    left.sort()
    right.sort()

    val n = left.size
    var s = 0L
    for (i in 0..<n) {
        s += abs(left[i] - right[i])
    }
    println(s)
}