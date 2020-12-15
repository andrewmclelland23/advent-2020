package travel

class CustomsDeclaration(val yesAnswers: List<String>) {
    init {
        yesAnswers.forEach { if (!it[0].isLetter()) throw IllegalArgumentException("Only letters can be inputted as answers") }
    }
}

class CustomsGroup(private val customsDeclarations: List<CustomsDeclaration>) {

    fun groupDeclarationUniqueValues(): CustomsDeclaration {
        return CustomsDeclaration(
            customsDeclarations.flatMap {
                it.yesAnswers
            }.distinct()
        )
    }

    fun groupDeclarationAgreedValues(): CustomsDeclaration {
        val answers = customsDeclarations.flatMap {
            it.yesAnswers
        }
        return CustomsDeclaration(
            answers.distinct().filter { letter ->
                answers.filter { it == letter }.size == customsDeclarations.size
            }
        )

    }
}