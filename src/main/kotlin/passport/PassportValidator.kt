package passport

data class PassportValidator(val passportListString: String) {
    private val passportList = Passport.toPassports(passportListString)

    fun countValid() : Int {
        return passportList.filter { it.isValid() }.size
    }
}