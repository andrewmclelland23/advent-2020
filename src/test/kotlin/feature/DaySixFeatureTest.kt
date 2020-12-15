package feature

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import travel.CustomsValidator

class DaySixFeatureTest : FreeSpec() {
    init {
        "Given a list of customs declarations in string format" - {
            "Find the sum of the unique answers represented in each group" {
                val input = javaClass.getResource("/input/DaySixFeatureTest").readText()

                val expectedResult = 6161

                CustomsValidator.calculateUniqueYesScore(input) shouldBe expectedResult
            }
            "Find the sum of the answers that every person in a group selected" {
                val input = javaClass.getResource("/input/DaySixFeatureTest").readText()

                val expectedResult = 2971

                CustomsValidator.calculateAllYesScore(input) shouldBe expectedResult
            }
        }
    }
}