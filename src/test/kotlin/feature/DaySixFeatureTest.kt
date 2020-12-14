package feature

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import travel.BoardingPass
import travel.CustomsValidator

class DaySixFeatureTest : FreeSpec() {
    init {
        "Given a list of boarding passes in bsp string format" - {
            "Find the boarding pass with the highest ID" {
//                val input = javaClass.getResource("/input/DaySixFeatureTest").readText()
                val input = "abc\n" +
                    "\n" +
                    "a\n" +
                    "b\n" +
                    "c\n" +
                    "\n" +
                    "ab\n" +
                    "ac\n" +
                    "\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "\n" +
                    "b"

                val expectedResult = 11

                CustomsValidator.stringInputToCustDecList(input) shouldBe expectedResult
            }
        }
    }
}