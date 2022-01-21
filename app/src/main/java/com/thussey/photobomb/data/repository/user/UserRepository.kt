package com.thussey.photobomb.data.repository.user

import com.thussey.photobomb.data.Result
import com.thussey.photobomb.data.model.user.User

interface UserRepository {

    suspend fun getUserById() : Result<User>
    suspend fun getUsers() : Result<List<User>>
}