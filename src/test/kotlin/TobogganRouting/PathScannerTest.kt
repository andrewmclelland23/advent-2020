package TobogganRouting

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class PathScannerTest : FreeSpec() {
    val input = "..##.......\n" +
        "#...#...#..\n" +
        ".#....#..#.\n" +
        "..#.#...#.#\n" +
        ".#...##..#.\n" +
        "..#.##.....\n" +
        ".#.#.#....#\n" +
        ".#........#\n" +
        "#.##...#...\n" +
        "#...##....#\n" +
        ".#..#...#.#"

    init {
        "PathScanner plotRoute should" - {
            "Calculate the number of trees encountered on the given route" {
                val pathScanner = PathScanner(input)
                val expectedResult = 7

                pathScanner.countTreesOnRoute(3, 1) shouldBe expectedResult
            }
        }
        "PathScanner plotRoutes should" - {
            "Calculate the total number of trees encountered on the given routes" {
                val pathScanner = PathScanner(input)
                val expectedResult = 336

                pathScanner.countTreesOnRoutes(listOf(Pair(1,1), Pair(3,1), Pair(5,1), Pair(7,1), Pair(1,2))) shouldBe expectedResult
            }
        }
    }
}