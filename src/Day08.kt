fun main() {
    val digitMap = mapOf(
        1 to 2,
        4 to 4,
        7 to 3,
        8 to 7
    )

    fun part1(input: List<String>): Int {
        return input.map { it.split(" | ")[1] }
            .map { it.split(" ") }
            .flatten()
            .groupBy { it.count() }
            .mapValues { it.value.size }
            .filterKeys { digitMap.containsValue(it) }
            .values
            .sum()
    }

    fun part2(input: List<String>): Int {
        TODO()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day08_test")
    println(part1(testInput))
    check(part1(testInput) == 26)
//    check(part2(testInput) == 168)

    val input = readInput("Day08")
    println(part1(input))
    println(part2(input))
}
