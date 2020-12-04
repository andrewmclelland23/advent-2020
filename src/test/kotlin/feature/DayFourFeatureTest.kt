package feature

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import passport.PassportValidator

class DayFourFeatureTest : FreeSpec() {
    init {
        "Given a list of passports" - {
            "Calculate the number of valid passports" {
                val input = javaClass.getResource("/input/DayFourFeatureTest").readText()
                val expectedResult = 132

                PassportValidator(input).countValid() shouldBe expectedResult
            }
        }
    }
}