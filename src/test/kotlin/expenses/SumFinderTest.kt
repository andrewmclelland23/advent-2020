package expenses

import expenses.SumFinder
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

class SumFinderTest : FreeSpec() {
    init {
        "expenses.SumFinder" - {
            "findRecursively should" - {
                "Find a the n number of entries that sum up to the given input" {
                    forAll(
                        row(listOf(979, 366, 299, 675, 1456, 1721), 2020, 2, listOf(1721, 299)),
                        row(listOf(300, 4, 302, 2, 306, 3, 307, 1, 308), 10, 4, listOf(2, 1, 3, 4))
                    ) { entries, targetNumber, numberOfMultiples, expectedResult ->

                        SumFinder().find(
                            targetNumber,
                            entries,
                            numberOfMultiples
                        ) shouldContainExactlyInAnyOrder expectedResult

                    }
                }
                "Return empty list when answer is not possible" {
                    val entries = listOf(2, 2)
                    val targetNumber = 5
                    SumFinder().find(targetNumber, entries, 2) shouldBe listOf()
                }
            }
        }
    }
}