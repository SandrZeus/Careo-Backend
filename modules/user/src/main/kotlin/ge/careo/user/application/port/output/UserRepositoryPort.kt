package ge.careo.user.application.port.output

import ge.careo.user.domain.model.PhoneNumber
import ge.careo.user.domain.model.User
import ge.careo.user.domain.model.UserId

interface UserRepositoryPort {
    fun save(user: User): User
    fun findById(id: UserId): User?
    fun findByFirebaseUid(firebaseUid: String): User?
    fun findByPhoneNumber(phoneNumber: PhoneNumber): User?
    fun existsByPhoneNumber(phoneNumber: PhoneNumber): Boolean
}