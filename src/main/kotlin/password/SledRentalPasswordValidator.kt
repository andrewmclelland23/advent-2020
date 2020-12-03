package password

import password.PasswordEntity.Companion.toPasswordEntity

class SledRentalPasswordValidator(passwordRecordsString: String): IPasswordValidator {
    override val records = passwordRecordsString.split("\n").map { toPasswordEntity(it) }

    override fun validate(): Int {
        val validRecords = records.filter { passwordEntity ->
            val lettersPresent = passwordEntity.password.filter { it == passwordEntity.letter }.length
            lettersPresent >= passwordEntity.numOne && lettersPresent <= passwordEntity.numTwo
        }
        return validRecords.size
    }
}

