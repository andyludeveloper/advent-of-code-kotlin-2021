fun main() {
    fun generateBingoList(input: List<String>, count: Int): MutableList<Int> {
        val tempList = mutableListOf<Int>()
        for (index in 2 + (count * 6)..6 + (count * 6)) {
            tempList.addAll(input[index].removePrefix(" ").split("  ", " ").toList().map { it.toInt() })
        }
        return tempList
    }

    fun isBingo(ints: MutableSet<Int>?): Boolean {
        val bingoCondition1 = listOf(0, 1, 2, 3, 4)
        val bingoCondition2 = listOf(5, 6, 7, 8, 9)
        val bingoCondition3 = listOf(10, 11, 12, 13, 14)
        val bingoCondition4 = listOf(15, 16, 17, 18, 19)
        val bingoCondition5 = listOf(20, 21, 22, 23, 24)
        val bingoCondition6 = listOf(0, 5, 10, 15, 20)
        val bingoCondition7 = listOf(1, 6, 11, 16, 21)
        val bingoCondition8 = listOf(2, 7, 12, 17, 22)
        val bingoCondition9 = listOf(3, 8, 13, 18, 23)
        val bingoCondition10 = listOf(4, 9, 14, 19, 24)
//        val bingoCondition11 = listOf(0, 6, 12, 18, 24)
//        val bingoCondition12 = listOf(4, 8, 12, 16, 20)
        return ints?.containsAll(bingoCondition1) == true ||
                ints?.containsAll(bingoCondition2) == true ||
                ints?.containsAll(bingoCondition3) == true ||
                ints?.containsAll(bingoCondition4) == true ||
                ints?.containsAll(bingoCondition5) == true ||
                ints?.containsAll(bingoCondition6) == true ||
                ints?.containsAll(bingoCondition7) == true ||
                ints?.containsAll(bingoCondition8) == true ||
                ints?.containsAll(bingoCondition9) == true ||
                ints?.containsAll(bingoCondition10) == true
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

    fun generateNonPickedValue(bingoList: List<Int>?, resultIndexTable: MutableSet<Int>?): List<Int> {
        val excluded = mutableListOf<Int>()
        bingoList?.forEachIndexed { index, i ->
            if (resultIndexTable?.contains(index) == false) {
                excluded.add(i)
            }
        }
        return excluded
    }

    fun generateAnswerList(input: List<String>): List<Int> {
        val answer = input[0].split(",").map { it.toInt() }
        return answer
    }

    fun part1(input: List<String>): Int {
        val answer = generateAnswerList(input)

        val bingoMaps = generateBingoMap(input)

        val resultIndexTable = mutableMapOf<Int, MutableSet<Int>>()
        answer.forEachIndexed { _, it ->
            for ((index, list) in bingoMaps) {
                if (list.contains(it)) {
                    val lastSet = resultIndexTable.getOrDefault(index, mutableSetOf())
                    lastSet.add(list.indexOf(it))
                    resultIndexTable[index] = lastSet
                }

                if (isBingo(resultIndexTable[index])) {
                    val notHit = generateNonPickedValue(
                        bingoMaps[index],
                        resultIndexTable[index],
                    )
                    return notHit.sum() * it
                }
            }
        }
        return input.size
    }

    fun part2(input: List<String>): Int {
        val answer = generateAnswerList(input)
        val bingoSet = mutableSetOf<Int>()
        val bingoMaps = generateBingoMap(input)

        val resultIndexTable = mutableMapOf<Int, MutableSet<Int>>()
        answer.forEachIndexed { _, it ->
            for ((index, list) in bingoMaps) {
                if (list.contains(it)) {
                    val lastSet = resultIndexTable.getOrDefault(index, mutableSetOf())
                    lastSet.add(list.indexOf(it))
                    resultIndexTable[index] = lastSet
                }

                if (isBingo(resultIndexTable[index])) {
                    bingoSet.add(index)
                    if(bingoSet.size == bingoMaps.count()){
                        val notHit = generateNonPickedValue(
                            bingoMaps[index],
                            resultIndexTable[index],
                        )
                        return notHit.sum() * it
                    }
                }
            }
        }
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 4512)
    check(part2(testInput) == 1924)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
