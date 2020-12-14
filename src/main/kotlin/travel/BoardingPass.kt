package travel

import kotlin.math.floor
import kotlin.math.roundToInt

class BoardingPass private constructor(val row: Int, val column: Int, val seatId: Int) {

    companion object {
        fun findMaxSeatId(bspStringList: String): Int {
            return bspStringList.split("\n").map {
                bspToBoardingPass(it)
            }.maxByOrNull {
                it.seatId
            }!!.seatId
        }

        fun findSpareSeat(bspStringList: String): Int? {
            bspStringList.split("\n").map {
                bspToBoardingPass(it)
            }.sortedBy {
                it.seatId
            }.reduce { acc, boardingPass ->
                if(boardingPass.row == acc.row && (boardingPass.seatId - acc.seatId) > 1 )  return boardingPass.seatId - 1
                boardingPass
            }
            return null
        }

        fun bspToBoardingPass(bspString: String): BoardingPass {
            val bsp = bspString.split("").filter { it != "" }
            val row = bsp.subList(0, 7)
            val seat = bsp.subList(7, 10)
            var rowSegment = Pair(0, 127)
            var seatSegment = Pair(0, 7)
            row.forEach {
                rowSegment = calculateSegment(rowSegment, it[0])
            }
            seat.forEach {
                seatSegment = calculateSegment(seatSegment, it[0])
            }
            return BoardingPass(rowSegment.first, seatSegment.first, (rowSegment.first * 8) + seatSegment.first)
        }

        private fun calculateSegment(segment: Pair<Int, Int>, direction: Char): Pair<Int, Int> {
            return if(direction == "F"[0] || direction == "L"[0]) {
                Pair(segment.first, floor(segment.second - ((segment.second.toDouble() - segment.first) / 2)).toInt())
            } else {
                Pair(segment.second - ((segment.second.toDouble() - segment.first) / 2).toInt(), segment.second)
            }
        }
    }
}