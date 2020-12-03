package password

import password.PasswordEntity.Companion.toPasswordEntity

class TobogganRentalPasswordValidator(passwordRecordsString: String): IPasswordValidator {
    override val records = passwordRecordsString.split("\n").map { toPasswordEntity(it) }

    override fun validate(): Int {
        val validRecords = records.filter { passwordEntity ->
            "${passwordEntity.password[passwordEntity.numOne-1]}${passwordEntity.password[passwordEntity.numTwo-1]}"
                .count { it == passwordEntity.letter } == 1
        }
        return validRecords.size
    }
}

