package travel

object CustomsValidator {

    fun stringInputToCustGroups(input: String): List<CustomsGroup> {
        return input.split("\n\n").map { group ->
            CustomsGroup(
                group.split("\n").map { individualAnswers ->
                    CustomsDeclaration(individualAnswers.chunked(1))
                }
            )
        }
    }

    fun calculateUniqueYesScore(customsListString: String): Int {
        return stringInputToCustGroups(customsListString).fold(0) { count, group ->
            count + group.groupDeclarationUniqueValues().yesAnswers.size
        }
    }

    fun calculateAllYesScore(customsListString: String): Int {
        return stringInputToCustGroups(customsListString).fold(0) { count, group ->
            count + group.groupDeclarationAgreedValues().yesAnswers.size
        }
    }
}