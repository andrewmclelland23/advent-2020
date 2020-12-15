package travel

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CustomsValidatorTest : FreeSpec() {
    init {
        "CustomsValidator calculateUniqueYesScore should" - {
            "Sum unique answers of CustomsGroups" {
                val expectedResult = 11

                CustomsValidator.calculateUniqueYesScore(input) shouldBe expectedResult
            }
        }
        "CustomsValidator calculateAllYesScore should" - {
            "Sum answers of CustomsGroup that were present for all" {
                val expectedResult = 6

                CustomsValidator.calculateAllYesScore(input) shouldBe expectedResult
            }
        }
    }

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
}