import ExpenseReport
import SumFinder
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class ExpenseReportTest: FreeSpec() {
    init {
        "ExpenseReport" - {
            "fixReport method should" {
                "Find the two entries that sum to input and then multiply those two numbers together" {
                    val input = "5\n5\n20"
                    val mockSumFinder = mockk<SumFinder>()
                    every { mockSumFinder.find(any(), any()) } returns listOf(5, 5)
                    val expenseReport = ExpenseReport(input, mockSumFinder)
                    val expectedResult = 25

                    expenseReport.fixReport(10) shouldBe expectedResult
                    verify { mockSumFinder.find(10, listOf(5, 5, 20)) }
                }
            }
        }
    }
}