package ge.careo.shared.api.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.Instant

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationErrors(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val errors = ex.bindingResult.fieldErrors.map { "${it.field}: ${it.defaultMessage}" }

        return ResponseEntity.badRequest().body(
            ErrorResponse(
                status = 400,
                error = "Validation Failed",
                messages = errors,
                timestamp = Instant.now()
            )
        )
    }

    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalState(ex: IllegalStateException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ErrorResponse(
                status = 409,
                error = "Conflict",
                messages = listOf(ex.message ?: "Conflict occurred"),
                timestamp = Instant.now()
            )
        )
    }

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(ex: NoSuchElementException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorResponse(
                status = 404,
                error = "Not Found",
                messages = listOf(ex.message ?: "Resource not found"),
                timestamp = Instant.now()
            )
        )
    }

    @ExceptionHandler(Exception::class)
    fun handleGeneral(ex: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity.internalServerError().body(
            ErrorResponse(
                status = 500,
                error = "Internal Server Error",
                messages = listOf("An unexpected error occurred"),
                timestamp = Instant.now()
            )
        )
    }
}