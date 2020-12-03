package expenses

class SumFinder {

    fun find(targetNumber: Int, entries: List<Int>, depth: Int): List<Int> {
        val result: MutableList<Int> = mutableListOf()
        entries.forEachIndexed { i, entry ->
            val potentialMatches = entries.toMutableList().also { it.removeAt(i) }
            val newTarget = targetNumber - entry
            if (depth > 2) {
                find(newTarget, potentialMatches, depth - 1).also {
                    if (it.isNotEmpty()) {
                        return it.toMutableList() + entry
                    }
                }
            } else {
                potentialMatches.find { it == newTarget }.also {
                    if (it != null) {
                        result.addAll(listOf(it, entry))
                        return result
                    }
                }
            }
        }
        return result
    }
}
