package ge.careo.user.application.port.input

import ge.careo.user.domain.model.User

interface GetUserUseCase {
    fun getByFirebaseUid(firebaseUid: String): User
    fun getById(id: String): User
}