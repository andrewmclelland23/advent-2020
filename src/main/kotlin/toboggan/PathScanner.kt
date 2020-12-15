package toboggan

class PathScanner(mapString: String) {
    val mapSegment = mapString.split("\n")

    fun countTreesOnRoute(x: Int, y: Int): Int {
        val requiredMapRepetitions = Math.ceil(((mapSegment.size / y) * x) / mapSegment[0].length.toDouble()).toInt()
        val fullMap = mapSegment.map { it.repeat(requiredMapRepetitions)  }
        var xPos = 0
        var yPos = 0
        var treeCount = 0

        repeat((mapSegment.size / y) - 1) {
            yPos += y
            xPos += x
            if (fullMap[yPos][xPos].toString() == "#") treeCount += 1
        }
        return treeCount
    }
    fun countTreesOnRoutes(movements: List<Pair<Int, Int>>): Int {
        return movements.map {
            countTreesOnRoute(it.first, it.second)
        }.fold(1) { treeCount, newTreeCount -> treeCount * newTreeCount }
    }
}