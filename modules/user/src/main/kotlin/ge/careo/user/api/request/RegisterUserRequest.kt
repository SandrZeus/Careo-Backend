package ge.careo.user.api.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class RegisterUserRequest(
    @field:NotBlank
    val firebaseUid: String,

    @field:NotBlank
    @field:Pattern(regexp = "^\\+[1-9]\\d{1,14}$", message = "Phone number must be in E.164 format")
    val phoneNumber: String,

    @field:NotBlank
    val firstName: String,

    @field:NotBlank
    val lastName: String,

    val gender: String?,

    val dateOfBirth: String?,
)
