package ge.careo.user.api.response

import ge.careo.user.domain.model.User
import java.time.Instant
import java.time.LocalDate

data class UserRespone(
    val id: String,
    val phoneNumber: String,
    val firstName: String,
    val lastName: String,
    val gender: String?,
    val dateOfBirth: LocalDate?,
    val createdAt: Instant,
) {
    companion object {
        fun from(user: User) = UserRespone(
            id = user.id.value.toString(),
            phoneNumber = user.phoneNumber.value,
            firstName = user.firstName,
            lastName = user.lastName,
            gender = user.gender?.name,
            dateOfBirth = user.dateOfBirth,
            createdAt = user.createdAt
        )
    }
}
