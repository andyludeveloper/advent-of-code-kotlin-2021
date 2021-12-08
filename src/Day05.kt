fun main() {
    fun part1(input: List<String>): Int {
        val mutableMapOf = mutableMapOf<Pair<Int, Int>, Int>()

        input.forEach {
            val split = it.split(" -> ")
            val x1y1 = split[0].split(",")
            val x2y2 = split[1].split(",")
            val x1 = x1y1[0].toInt()
            val y1 = x1y1[1].toInt()
            val x2 = x2y2[0].toInt()
            val y2 = x2y2[1].toInt()

            if (x1 == x2) {
                if (y1 > y2) {
                    for (index in y2..y1) {
                        val pair = Pair(x1, index)
                        var value = mutableMapOf.getOrDefault(pair, 0)
                        mutableMapOf[pair] = ++value
                    }
                } else {
                    for (index in y1..y2) {
                        val pair = Pair(x1, index)
                        var value = mutableMapOf.getOrDefault(pair, 0)
                        mutableMapOf[pair] = ++value
                    }
                }
            }

            if (y1 == y2) {
                if (x1 < x2) {
                    for (index in x1..x2) {
                        val pair = Pair(index, y1)
                        var value = mutableMapOf.getOrDefault(pair, 0)
                        mutableMapOf[pair] = ++value
                    }
                } else {
                    for (index in x2..x1) {
                        val pair = Pair(index, y1)
                        var value = mutableMapOf.getOrDefault(pair, 0)
                        mutableMapOf[pair] = ++value
                    }
                }
            }
        }

        return mutableMapOf.filterValues { it >= 2 }.count()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == 5)
//    check(part2(testInput) == 1924)

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
