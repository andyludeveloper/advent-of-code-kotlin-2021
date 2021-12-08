fun main() {

    fun part1(input: List<String>): Int {
        val fishes = input[0]
            .split(",")
            .mapIndexed { index, it -> index to it.toLong() }
            .toMap()
            .toMutableMap()

        var times = 0
        while (times < 80) {
            var add8 = 0
            fishes.forEach { (index, value) ->
                if (value > 0) fishes[index] = value -1 else {
                    ++add8
                    fishes[index] = 6
                }
            }

            for (add8Times in 0 until add8) {
                fishes[fishes.size] = 8
            }
            times++
        }
        return fishes.count()
    }

    fun part2(input: List<String>): Long {
        val fishes = input[0]
            .split(",")
            .mapIndexed { index, it -> index to it.toLong() }
            .toMap()
            .toMutableMap()

        var times = 0
        while (times < 256) {
            var add8 = 0
            fishes.forEach { (index, value) ->
                if (value > 0) fishes[index] = value -1 else {
                    ++add8
                    fishes[index] = 6
                }
            }

            for (add8Times in 0 until add8) {
                fishes[fishes.size] = 8
            }
            times++
        }
        return fishes.count().toLong()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    println(part1(testInput))
    check(part1(testInput) == 5934)
    check(part2(testInput) == 26984457539)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
