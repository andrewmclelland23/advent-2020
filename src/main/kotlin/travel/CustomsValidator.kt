package travel

object CustomsValidator {

    fun stringInputToCustDecList(input: String): List<List<CustomsDeclaration>> {
        return input.split("\n\n").map { group ->
            group.split("\n").map { individualAnswers ->
                CustomsDeclaration(individualAnswers.split(""))
            }
        }
    }
}