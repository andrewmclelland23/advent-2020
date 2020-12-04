package passport

open class Passport(
    val byr: Int?,
    val iyr: Int?,
    val eyr: Int?,
    val hgt: Pair<Int?, String?>,
    val hcl: String?,
    val ecl: String?,
    val pid: String?,
    val cid: String?
) {

    open fun isValid(): Boolean {
        return when {
            byr == null -> false
            byr > 2002  -> false
            byr < 1920  -> false
            iyr == null -> false
            iyr < 2010  -> false
            iyr > 2020  -> false
            eyr == null -> false
            eyr > 2030  -> false
            eyr < 2020  -> false
            hgt.first == null -> false
            hgt.second == null -> false
            ((hgt.second == "cm") and ((hgt.first!! < 150) or (hgt.first!! >193))) -> false
            ((hgt.second == "in") and ((hgt.first!! < 59) or (hgt.first!! >76))) -> false
            hcl == null -> false
            hcl[0].toString() != "#" -> false
            !hcl.substring(1).contains("^[0-9a-f]{6}$".toRegex()) -> false
            ecl == null -> false
            !ecl.contains("^[amb|blu|brn|gry|grn|hzl|oth]{3}".toRegex())-> false
            pid == null -> false
            pid.length != 9 -> false
            pid.toIntOrNull() == null -> false
            else -> true
        }
    }

    companion object {
        fun toPassports(unformattedRecordString: String): List<Passport> {
            val recordsString = recordStringParser(unformattedRecordString)
            return recordsString.map { map ->
                val hgtUnit = map["hgt"]?.findAnyOf(listOf("in", "cm"), 0, false)
                val hgtValue = hgtUnit?.first?.let { map["hgt"]?.substring(0, hgtUnit.first)?.toIntOrNull() }
                Passport(
                    byr = map["byr"]?.toInt(),
                    iyr = map["iyr"]?.toInt(),
                    eyr = map["eyr"]?.toInt(),
                    hgt = Pair(hgtValue, hgtUnit?.second),
                    hcl = map["hcl"],
                    ecl = map["ecl"],
                    pid = map["pid"],
                    cid = map["cid"]
                )
            }
        }

        private fun recordStringParser(recordString: String): List<Map<String, String>> {
            return recordString.split("\n\n").map {
                it.split("\n", " ").fold(emptyMap()) { map, recordString ->
                    val splitRec = recordString.split(":")
                    map + mapOf(splitRec[0] to splitRec[1])
                }
            }
        }
    }
}