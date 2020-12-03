package password

data class PasswordEntity(val numOne: Int, val numTwo: Int, val letter: Char, val password: String) {

    companion object {
        fun toPasswordEntity(recordString: String): PasswordEntity {
            var password: String
            var min: Int
            var max: Int
            var letter: Char

            recordString.split(":").also {
                password = it[1].trim()
                it[0].split(" ").also {
                    letter = it[1][0]
                    it[0].split("-").also {
                        min = it[0].toInt()
                        max = it[1].toInt()
                    }
                }
            }
            return PasswordEntity(min, max, letter, password)
        }
    }
}