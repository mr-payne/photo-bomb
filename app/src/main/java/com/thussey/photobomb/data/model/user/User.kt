package com.thussey.photobomb.data.model.user

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class User(
    val id: String,
    val email : String,
)