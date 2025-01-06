fun main() {
    val input = generateSequence(::readLine)
    var s = 0
    for (line in input) {
        val re = "mul\\((\\d{1,3}),(\\d{1,3})\\)".toRegex()
        val matches = re.findAll(line)
        for (m in matches) {
            s += m.groups[1]!!.value.toInt() * m.groups[2]!!.value.toInt()
        }
    }
    println(s)
}
