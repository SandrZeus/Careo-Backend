package ge.careo.user.infrastructure.persistence.adapter

import ge.careo.user.application.port.output.UserRepositoryPort
import ge.careo.user.domain.model.PhoneNumber
import ge.careo.user.domain.model.User
import ge.careo.user.domain.model.UserId
import ge.careo.user.infrastructure.persistence.repository.UserJpaRepository

class UserRepositoryAdapter(
    private val userJpaRepository: UserJpaRepository
) : UserRepositoryPort {
    override fun save(user: User): User {
        val entity = UserMapper.toEntity(user)
        val saved = userJpaRepository.save(entity)
        return UserMapper.toDomain(saved)
    }

    override fun findById(id: UserId): User? {
        return userJpaRepository.findById(id.value)
            .map { UserMapper.toDomain(it) }
            .orElse(null)
    }

    override fun findByFirebaseUid(firebaseUid: String): User? {
        return userJpaRepository.findByFirebaseUid(firebaseUid)
            ?.let { UserMapper.toDomain(it) }
    }

    override fun findByPhoneNumber(phoneNumber: PhoneNumber): User? {
        return userJpaRepository.findByPhoneNumber(phoneNumber.value)
            ?.let { UserMapper.toDomain(it) }
    }

    override fun existsByPhoneNumber(phoneNumber: PhoneNumber): Boolean {
        return userJpaRepository.existsByPhoneNumber(phoneNumber.value)
    }
}