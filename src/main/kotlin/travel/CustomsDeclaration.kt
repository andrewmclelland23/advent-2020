package travel

class CustomsDeclaration(val yesAnswers: List<String>) {
    init {
        yesAnswers.forEach { if(!it[0].isLetter()) throw IllegalArgumentException("Only letters can be inputted as answers")}
    }
}