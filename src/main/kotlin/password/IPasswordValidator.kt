package password

interface IPasswordValidator {
    val records: List<PasswordEntity>
    fun validate(): Int
}