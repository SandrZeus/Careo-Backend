package ge.careo.user.infrastructure.persistence.adapter

import ge.careo.user.domain.model.Gender
import ge.careo.user.domain.model.PhoneNumber
import ge.careo.user.domain.model.User
import ge.careo.user.domain.model.UserId
import ge.careo.user.infrastructure.persistence.entity.GenderEntity
import ge.careo.user.infrastructure.persistence.entity.UserEntity

object UserMapper {
    fun toDomain(entity: UserEntity): User = User(
        id = UserId(entity.id),
        firebaseUid = entity.firebaseUid,
        phoneNumber = PhoneNumber(entity.phoneNumber),
        firstName = entity.firstName,
        lastName = entity.lastName,
        gender = entity.gender?.let { Gender.valueOf(it.name) },
        dateOfBirth = entity.dateOfBirth,
        isActive = entity.isActive,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt
    )

    fun toEntity(domain: User): UserEntity = UserEntity(
        id = domain.id.value,
        firebaseUid = domain.firebaseUid,
        phoneNumber = domain.phoneNumber.value,
        firstName = domain.firstName,
        lastName = domain.lastName,
        gender = domain.gender?.let { GenderEntity.valueOf(it.name) },
        dateOfBirth = domain.dateOfBirth,
        isActive = domain.isActive,
        createdAt = domain.createdAt,
        updatedAt = domain.updatedAt
    )
}