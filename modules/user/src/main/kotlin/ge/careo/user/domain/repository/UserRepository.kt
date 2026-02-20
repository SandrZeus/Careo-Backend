package ge.careo.user.domain.repository

import ge.careo.user.domain.model.PhoneNumber
import ge.careo.user.domain.model.User
import ge.careo.user.domain.model.UserId

interface UserRepository {
    fun save(user: User): User
    fun findById(id: UserId): User?
    fun findByPhoneNumber(phoneNumber: PhoneNumber): User?
    fun findByFirebaseUid(firebaseUid: String): User?
    fun existsByPhoneNumber(phoneNumber: PhoneNumber): Boolean
}