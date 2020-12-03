package feature

import password.SledRentalPasswordValidator
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import password.TobogganRentalPasswordValidator

class DayTwoFeatureTest : FreeSpec() {
    init {
        "Given list of passwords and their rules (sled rental policy)" - {
            "Calculate the number of valid passwords" {
                val input = javaClass.getResource("/input/DayTwoFeatureTest").readText()
                val validator = SledRentalPasswordValidator(input)
                val expectedResult = 445

                validator.validate() shouldBe expectedResult
            }
        }
        "Given list of passwords and their rules (toboggan rental policy)" - {
            "Calculate the number of valid passwords" {
                val input = javaClass.getResource("/input/DayTwoFeatureTest").readText()
                val validator = TobogganRentalPasswordValidator(input)
                val expectedResult = 491

                validator.validate() shouldBe expectedResult
            }
        }
    }
}