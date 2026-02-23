package ge.careo.user.api.controller

import ge.careo.user.api.request.RegisterUserRequest
import ge.careo.user.api.response.UserRespone
import ge.careo.user.application.port.input.RegisterUserCommand
import ge.careo.user.application.port.input.RegisterUserUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val registerUserUseCase: RegisterUserUseCase,
) {
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@Valid @RequestBody request: RegisterUserRequest): UserRespone {
        val command = RegisterUserCommand(
            firebaseUid = request.firebaseUid,
            phoneNumber = request.phoneNumber,
            firstName = request.firstName,
            lastName = request.lastName,
            gender = request.gender,
            dateOfBirth = request.dateOfBirth
        )
        val user = registerUserUseCase.register(command)
        return UserRespone.from(user)
    }
}