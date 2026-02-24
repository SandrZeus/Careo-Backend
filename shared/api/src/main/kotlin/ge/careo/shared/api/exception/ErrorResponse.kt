package ge.careo.shared.api.exception

import java.time.Instant

data class ErrorResponse(
    val status: Int,
    val error: String,
    val messages: List<String>,
    val timestamp: Instant
)
