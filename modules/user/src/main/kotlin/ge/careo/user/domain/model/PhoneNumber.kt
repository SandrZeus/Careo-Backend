package ge.careo.user.domain.model

@JvmInline
value class PhoneNumber(
    val value: String
) {
    init {
        require(value.matches(Regex("^\\+[1-9]\\d{1,14}$"))) {
            "Phone number must be in E.164 format"
        }
    }
}