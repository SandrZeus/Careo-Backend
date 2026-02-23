package ge.careo.user.infrastructure.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    val id: UUID,

    @Column(name = "firebase_uid", nullable = false, unique = true)
    val firebaseUid: String,

    @Column(name = "phone_number", nullable = false, unique = true)
    val phoneNumber: String,

    @Column(name = "first_name", nullable = false)
    val firstName: String,

    @Column(name = "last_name", nullable = false)
    val lastName: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    val gender: GenderEntity?,

    @Column(name = "date_of_birth")
    val dateOfBirth: LocalDate?,

    @Column(name = "is_active", nullable = false)
    val isActive: Boolean,

    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)

enum class GenderEntity {
    MALE, FEMALE
}