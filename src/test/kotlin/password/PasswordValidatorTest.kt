package password

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class PasswordValidatorTest : FreeSpec() {
    init {
        "SledRentalPasswordValidator validate should" - {
            "Calculate the number of valid passwords" {
                val input = "1-3 a: abcde\n1-3 b: cdefg\n2-9 c: ccccccccc"
                val validator = SledRentalPasswordValidator(input)
                val expectedResult = 2

                validator.validate() shouldBe expectedResult
            }
        }
        "TobogganRentalPasswordValidator validate should" - {
            "Calculate the number of valid passwords" {
                val input = "1-3 a: abcde\n1-3 b: cdefg\n2-9 c: ccccccccc"
                val validator = TobogganRentalPasswordValidator(input)
                val expectedResult = 1

                validator.validate() shouldBe expectedResult
            }
        }
    }
}