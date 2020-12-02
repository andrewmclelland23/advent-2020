import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

class SumFinderTest: FreeSpec() {
    init {
        "SumFinder 'finder' method should" - {
            "Find the two entries that sum to a given number" {
                val entries = listOf(979, 366, 299, 675, 1456, 1721)
                val targetNumber = 2020
                val expectedResult = listOf(1721, 299)

                SumFinder().find(targetNumber, entries) shouldContainExactlyInAnyOrder expectedResult
            }
            "Throw exception when answer is not possible" {
                val entries = listOf(2, 2)
                val targetNumber = 5
                val exception = shouldThrow<IllegalArgumentException> {
                    SumFinder().find(targetNumber, entries)
                }
                exception.message shouldBe "ERROR: No 2 of the given entries add up to the target number"
            }
        }
    }
}