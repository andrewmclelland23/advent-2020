class ExpenseReport(expenseReportString: String, private val sumFinder: SumFinder) {
    private val expenseReport = stringToIntList(expenseReportString)

    fun fixReport(input: Int): Int {
        val result = sumFinder.find(input, expenseReport).fold(1) { a, b -> a * b }
        println("ExpenseReport Result: Solution is $result")
        return result
    }

    private fun stringToIntList(newLineSeparatedList: String) =
        newLineSeparatedList.split("\n").map { it.toInt() }
}