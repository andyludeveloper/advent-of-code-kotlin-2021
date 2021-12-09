fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    val input = readInput("Day02")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)
    println(part1(input))
    println(part2(input))
}
