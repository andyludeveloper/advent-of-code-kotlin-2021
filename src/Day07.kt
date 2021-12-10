import kotlin.math.*

fun main() {

    fun part1(input: List<String>): Int {
        val crabPosition = input[0].split(",").map { it.toInt() }
        val fuelMap = mutableMapOf<Int, Int>()
        for (time in crabPosition.indices) {
            fuelMap[time] = crabPosition.fold(0) { acc, i ->
                acc + (abs(i - time))
            }
        }
        return fuelMap.values.toList().minOf { it }
    }

    fun part2(input: List<String>): Long {
        TODO()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    println(part1(testInput))
    check(part1(testInput) == 37)
//    check(part2(testInput) == 26984457539)

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}
