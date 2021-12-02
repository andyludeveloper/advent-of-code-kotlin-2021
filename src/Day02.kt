fun main() {

    fun part1(input: List<String>): Int {
        var horizontal:Int = 0
        var vertical:Int = 0
        
        input.forEach{
            
            val directionMap = it.split(" ")
            val direction = directionMap.first().toString()
            val count = directionMap.last().toInt()
            when(direction){
                "forward"-> horizontal+= count
                "up" -> vertical-=count
                "down" -> vertical += count
            }

        }
        
        return horizontal * vertical
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0

        input.forEach{
            val directionMap = it.split(" ")
            val direction = directionMap.first().toString()
            val count = directionMap.last().toInt()
            when(direction){
                "forward"-> {
                    horizontal+= count
                    depth += (aim * count)
                }
                "up" -> aim-=count
                "down" -> aim += count
            }

        }

        return horizontal * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
