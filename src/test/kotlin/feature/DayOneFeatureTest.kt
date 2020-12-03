package feature

import expenses.ExpenseReport
import expenses.SumFinder
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class DayOneFeatureTest: FreeSpec() {
    init {
        "In expense report" - {
            "Find the two entries that sum to 2020 and then multiply those two numbers together" {
                val input = javaClass.getResource("/input/DayOneFeatureTest").readText()
                val expenseReport = ExpenseReport(input, SumFinder())
                val expectedResult = 1018944

                expenseReport.fixReport(2020, 2) shouldBe expectedResult
            }
        }
        "Find the three entries that sum to 2020 and then multiply those three numbers together" {
            val input = javaClass.getResource("/input/DayOneFeatureTest").readText()
            val expenseReport = ExpenseReport(input, SumFinder())
            val expectedResult = 8446464

            expenseReport.fixReport(2020, 3) shouldBe expectedResult
        }
    }
}