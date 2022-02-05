package com.thussey.photobomb.data.model.user

import java.util.*

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class User(
    val id: String = UUID.randomUUID().toString(),
    val email : String,
)