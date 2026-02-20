package ge.careo.user.domain.model

import java.time.LocalDate
import java.time.Instant

data class User(
    val id: UserId,
    val firebaseUid: String,
    val phoneNumber: PhoneNumber,
    val firstName: String,
    val lastName: String,
    val gender: Gender?,
    val dateOfBirth: LocalDate?,
    val isActive: Boolean,
    val createdAt: Instant,
    val updatedAt: Instant
)
