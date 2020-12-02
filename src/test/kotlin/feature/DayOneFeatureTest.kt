package feature

import ExpenseReport
import SumFinder
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class DayOneFeatureTest: FreeSpec() {
    init {
        "In expense report" - {
            "Find the two entries that sum to 2020 and then multiply those two numbers together" {
                val input = javaClass.getResource("/input/DayOneFeatureTest").readText()
                val expenseReport = ExpenseReport(input, SumFinder())
                val expectedResult = 1018944

                expenseReport.fixReport(2020) shouldBe expectedResult
            }
        }
    }
}