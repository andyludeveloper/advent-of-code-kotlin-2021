import kotlin.math.*

fun main() {
    fun horizontalLine(
        y1: Int,
        y2: Int,
        x1: Int,
        mutableMapOf: MutableMap<Pair<Int, Int>, Int>
    ) {
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

    fun verticalLine(
        x1: Int,
        x2: Int,
        y1: Int,
        mutableMapOf: MutableMap<Pair<Int, Int>, Int>
    ) {
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
                horizontalLine(y1, y2, x1, mutableMapOf)
            }

            if (y1 == y2) {
                verticalLine(x1, x2, y1, mutableMapOf)
            }
        }

        return mutableMapOf.filterValues { it >= 2 }.count()
    }

    fun part2(input: List<String>): Int {
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
                horizontalLine(y1, y2, x1, mutableMapOf)
            }

            if (y1 == y2) {
                verticalLine(x1, x2, y1, mutableMapOf)
            }

            if (abs(x2 - x1) == abs(y2 - y1)) {
                if (x1 < x2 && y1 < y2) {
                    for (index in 0..abs(x2 - x1)) {
                        val pair = Pair(x1 + index, y1 + index)
                        var value = mutableMapOf.getOrDefault(pair, 0)
                        mutableMapOf[pair] = ++value
                    }
                }

                if (x1 < x2 && y1 > y2) {
                    for (index in 0..abs(x2 - x1)) {
                        val pair = Pair(x1 + index, y1 - index)
                        var value = mutableMapOf.getOrDefault(pair, 0)
                        mutableMapOf[pair] = ++value
                    }

                }
                if (x1 > x2 && y1 < y2) {
                    for (index in 0..abs(x2 - x1)) {
                        val pair = Pair(x1 - index, y1 + index)
                        var value = mutableMapOf.getOrDefault(pair, 0)
                        mutableMapOf[pair] = ++value
                    }
                }

                if (x1 > x2 && y1 > y2) {
                    for (index in 0..abs(x2 - x1)) {
                        val pair = Pair(x1 - index, y1 - index)
                        var value = mutableMapOf.getOrDefault(pair, 0)
                        mutableMapOf[pair] = ++value
                    }
                }
            }
        }
        return mutableMapOf.filterValues { it >= 2 }.count()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == 5)
    println(part2(testInput))
    check(part2(testInput) == 12)

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
