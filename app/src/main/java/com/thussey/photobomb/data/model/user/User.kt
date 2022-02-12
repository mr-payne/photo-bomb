package com.thussey.photobomb.data.model.user

import java.util.*

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class User(
    val id: UUID = UUID.randomUUID(),
    val email : String,
)