fun main() {

    fun part1(input: List<String>): Int {
        val initialList = input[0].split(",").map { it.toInt() }
        var fishes = mutableListOf<Int>()
        fishes.addAll(initialList)
        var times = 0
        while (times < 256) {
            var add8 = 0
            val nextDay = fishes.map {
                if (it > 0) it - 1 else {

                    ++add8
                    6
                }
            }.toMutableList()
            for (add8Times in 0 until add8) {
                nextDay.add(8)
            }
            println("times:$times, $nextDay")
            fishes = nextDay
            times++
        }
        return fishes.count()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    println(part1(testInput))
    check(part1(testInput) == 5934)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
