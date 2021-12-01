fun main() {
    fun part1(input: List<String>): Int {
        var lastItem = 0
        var result = 0
        input.forEach {
            val value = it.toInt()
            if (lastItem != 0 && value > lastItem) {
                result++
            }
            lastItem = value

        }
        return result
    }

    fun part2(input: List<String>): Int {
        var lastItem = 0
        var result = 0

        input.forEachIndexed { index, s ->
            val first: Int
            val second: Int
            val third: Int

            if (input.size-1 >= index + 2) {
                first = input[index].toInt()
                second = input[index + 1].toInt()
                third = input[index + 2].toInt()
                val value = first + second + third

                if (lastItem != 0 && value > lastItem) {
                    result++
                }
                lastItem = value
            }
        }
        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    val input = readInput("Day01")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)
    println(part1(input))
    println(part2(input))
}
