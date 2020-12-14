package feature

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import travel.BoardingPass

class DayFiveFeatureTest : FreeSpec() {
    init {
        "Given a list of boarding passes in bsp string format" - {
            "Find the boarding pass with the highest ID" {
                val input = javaClass.getResource("/input/DayFiveFeatureTest").readText()
                val expectedResult = 922

                BoardingPass.findMaxSeatId(input) shouldBe expectedResult
            }
            "Find the spare seat" {
                val input = javaClass.getResource("/input/DayFiveFeatureTest").readText()
                val expectedResult = 747

                BoardingPass.findSpareSeat(input) shouldBe expectedResult
            }
        }
    }
}