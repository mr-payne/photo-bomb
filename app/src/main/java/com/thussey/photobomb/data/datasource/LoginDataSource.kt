package com.thussey.photobomb.data.datasource

import com.thussey.photobomb.data.Result
import com.thussey.photobomb.data.model.user.User
import java.io.IOException
import java.util.*
import javax.inject.Inject

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource @Inject constructor() {

    fun login(username: String, password: String): Result<User> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = User(UUID.randomUUID(), "JaneDoe@gmail.com")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}