fun main() {
    val input = generateSequence(::readLine)

    val left = ArrayList<Int>()
    val right = HashMap<Int, Int>()
    for (line in input) {
        val (l, r) = line.split("\\s+".toRegex()).map { it.toInt() }
        left.add(l)
        right[r] = (right[r] ?: 0) + 1
    }
    var s = 0L
    for (l in left) {
        val d = l * (right[l] ?: 0)
        s += d
    }
    println(s)
}