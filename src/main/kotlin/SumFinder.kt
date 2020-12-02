class SumFinder {

    fun find(targetNumber: Int, entries: List<Int>): List<Int> {
        entries.forEachIndexed { i, entry ->
            val potentialMatches = entries.toMutableList().also { it.removeAt(i) }
            val requiredNumber = targetNumber - entry
            val result = potentialMatches.find { it == requiredNumber }
            if(result != null) {
                println("SumFinder Result: $entry + $result = $targetNumber")
                return listOf(entry, result)
            }
        }
        throw IllegalArgumentException("ERROR: No 2 of the given entries add up to the target number")
    }
}
