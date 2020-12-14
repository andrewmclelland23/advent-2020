package travel

import io.kotest.assertions.asClue
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class BoardingPassTest : FreeSpec() {
    init {
        "BoardingPass bspToBoardingPass method should" - {
            "Convert bsp string to BoardingPass" {
                forAll(
                    row("FBFBBFFRLR", 44, 5, 357),
                    row("BFFFBBFRRR", 70, 7, 567),
                    row("FFFBBBFRRR", 14, 7, 119),
                    row("BBFFBBFRLL", 102, 4, 820)
                ) { input, row, column, seatId ->
                    BoardingPass.bspToBoardingPass(input).asClue {
                        it.row shouldBe row
                        it.column shouldBe column
                        it.seatId shouldBe seatId
                    }
                }
            }
        }
    }
}