import kotlin.math.*

fun main() {

    fun part1(input: List<String>): Int {
        val mapOf = mutableMapOf<Int, Int>()
        input.forEach {
            it.toCharArray().reversed().forEachIndexed { index, c ->
                if (c == '1') {
                    val count = mapOf.getOrDefault(index, 0)
                    mapOf[index] = count + 1
                }
            }
        }
        val encoded1 = CharArray(mapOf.size)
        mapOf.forEach { (index, value) -> encoded1[index] = if (value > input.size / 2) '1' else '0' }
        val encoded2 = encoded1.map { if (it == '1') '0' else '1' }

        var gammaRate = 0.0
        encoded1.forEachIndexed { index, c -> gammaRate += c.digitToInt()*2.0.pow(index) }

        var epsilonRate = 0.0
        encoded2.forEachIndexed { index, c -> epsilonRate += c.digitToInt()*2.0.pow(index) }
        return gammaRate.toInt() * epsilonRate.toInt()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
//    check(part2(testInput) == 900)
//
    val input = readInput("Day03")
    println(part1(input))
//    println(part2(input))
}
