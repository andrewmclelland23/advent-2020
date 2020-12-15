package feature

import toboggan.PathScanner
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class DayThreeFeatureTest : FreeSpec() {
    init {
        "Given a map of trees/spaces and a movement pattern" - {
            "Calculate the number of trees encountered on the route" {
                val input = javaClass.getResource("/input/DayThreeFeatureTest").readText()
                val pathScanner = PathScanner(input)
                val expectedResult = 209

                pathScanner.countTreesOnRoute(3, 1) shouldBe expectedResult
            }
        }
        "Given a map of trees/spaces and a multiple movement patterns" - {
            "Calculate the total number of trees encountered on all the routes" {
                val input = javaClass.getResource("/input/DayThreeFeatureTest").readText()
                val pathScanner = PathScanner(input)
                val expectedResult = 1574890240

                pathScanner.countTreesOnRoutes(listOf(Pair(1,1), Pair(3,1), Pair(5,1), Pair(7,1), Pair(1,2))) shouldBe expectedResult
            }
        }
    }
}