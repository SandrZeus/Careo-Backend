package ge.careo.user.infrastructure.persistence.repository

import ge.careo.user.infrastructure.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserJpaRepository : JpaRepository<UserEntity, UUID> {
    fun findByFirebaseUid(firebaseUid: String): UserEntity?
    fun findByPhoneNumber(phoneNumber: String): UserEntity?
    fun existsByPhoneNumber(phoneNumber: String): Boolean
}