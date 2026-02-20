package ge.careo.user.application.port.input

import ge.careo.user.domain.model.User

interface RegisterUserUseCase {
    fun register(command: RegisterUserCommand): User
}

data class RegisterUserCommand(
    val firebaseUid: String,
    val phoneNumber: String,
    val firstName: String,
    val lastName: String,
    val gender: String?,
    val dateOfBirth: String?
)