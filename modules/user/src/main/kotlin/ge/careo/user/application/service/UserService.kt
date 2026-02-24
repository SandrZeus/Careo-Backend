package ge.careo.user.application.service

import ge.careo.user.application.port.input.GetUserUseCase
import ge.careo.user.application.port.input.RegisterUserCommand
import ge.careo.user.application.port.input.RegisterUserUseCase
import ge.careo.user.application.port.output.UserRepositoryPort
import ge.careo.user.domain.model.Gender
import ge.careo.user.domain.model.PhoneNumber
import ge.careo.user.domain.model.User
import ge.careo.user.domain.model.UserId
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.UUID
import java.time.Instant

@Service
class UserService(
    private val userRepositoryPort: UserRepositoryPort
) : RegisterUserUseCase, GetUserUseCase {
    override fun register(command: RegisterUserCommand): User {
        val phoneNumber = PhoneNumber(command.phoneNumber)

        check(!userRepositoryPort.existsByPhoneNumber(phoneNumber)) {
            "User already exists for phone number ${command.phoneNumber}"
        }

        val user = User(
            id = UserId(UUID.randomUUID()),
            firebaseUid = command.firebaseUid,
            phoneNumber = phoneNumber,
            firstName = command.firstName,
            lastName = command.lastName,
            gender = command.gender?.let { Gender.valueOf(it) },
            dateOfBirth = command.dateOfBirth?.let { LocalDate.parse(it) },
            isActive = true,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )

        return userRepositoryPort.save(user)
    }

    override fun getByFirebaseUid(firebaseUid: String): User {
        return userRepositoryPort.findByFirebaseUid(firebaseUid)
            ?: throw NoSuchElementException("User $firebaseUid not found")
    }

    override fun getById(id: String): User {
        return userRepositoryPort.findById(UserId(UUID.fromString(id)))
            ?: throw NoSuchElementException("User with id $id not found")
    }
}