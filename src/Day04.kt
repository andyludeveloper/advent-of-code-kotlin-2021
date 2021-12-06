fun main() {
    fun generateBingoList(input: List<String>, count: Int): MutableList<Int> {
        val tempList = mutableListOf<Int>()
        for (index in 2 + (count * 6)..6 + (count * 6)) {
            tempList.addAll(input[index].removePrefix(" ").split("  ", " ").toList().map { it.toInt() })
        }
        return tempList
    }

    fun isBingo(ints: MutableSet<Int>?): Boolean {
        val bingoCondition1 = listOf(1,2,3,4,5)
        val bingoCondition2 = listOf(6,7,8,9,10)
        val bingoCondition3 = listOf(11,12,13,14,15)
        val bingoCondition4 = listOf(16,17,18,19,20)
        val bingoCondition5 = listOf(21,22,23,24,25)
        val bingoCondition6 = listOf(1,6,11,16,21)
        val bingoCondition7 = listOf(2,7,12,17,22)
        val bingoCondition8 = listOf(3,8,13,18,23)
        val bingoCondition9 = listOf(4,9,14,19,24)
        val bingoCondition10 = listOf(5,10,15,20,25)
        val bingoCondition11 = listOf(1,7,13,19,25)
        val bingoCondition12 = listOf(5,9,13,17,21)
        return ints?.containsAll(bingoCondition1) == true ||
                ints?.containsAll(bingoCondition2) == true ||
                ints?.containsAll(bingoCondition3) == true ||
                ints?.containsAll(bingoCondition4) == true ||
                ints?.containsAll(bingoCondition5) == true ||
                ints?.containsAll(bingoCondition6) == true ||
                ints?.containsAll(bingoCondition7) == true ||
                ints?.containsAll(bingoCondition8) == true ||
                ints?.containsAll(bingoCondition9) == true ||
                ints?.containsAll(bingoCondition10) == true ||
                ints?.containsAll(bingoCondition11) == true ||
                ints?.containsAll(bingoCondition12) == true
    }

    fun generateBingoMap(
        input: List<String>,
    ): MutableMap<Int, List<Int>> {
        var index = 0
        val bingoMaps = mutableMapOf<Int, List<Int>>()
        while (input.size > 6 + (index * 6)) {
            bingoMaps[index] = generateBingoList(input, index)
            index++
        }
        return bingoMaps
    }

    fun generateNonPickedValue(ints: MutableSet<Int>?): Any {
        TODO("Not yet implemented")
    }

    fun part1(input: List<String>): Int {
        val answer = input[0].split(",").toList().map { it.toInt() }

        val bingoMaps = generateBingoMap(input)

        val resultTable = mutableMapOf<Int, MutableSet<Int>>()
        answer.forEachIndexed { answerIndex, it ->
            for ((index, list) in bingoMaps) {
                if (list.contains(it)) {
                    val lastSet = resultTable.getOrDefault(index, mutableSetOf())
                    lastSet.add(list.indexOf(it))
                    resultTable[index] = lastSet
                }

                if (isBingo(resultTable[index])) {
                    val partialAnswer = answer.subList(0, answerIndex)
                    val notHit = resultTable[index]?.filterNot { partialAnswer }
                    return notHit?.fold(1){acc, i ->  acc*i} ?: 0
                }
            }
        }
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 1)

//    val input = readInput("Day04")
//    println(part1(input))
//    println(part2(input))
}
