package com.thussey.photobomb.data.repository.user

import com.thussey.photobomb.data.Result
import com.thussey.photobomb.data.model.user.User
import okhttp3.ResponseBody
import java.util.*

interface UserRepository {

    suspend fun getUserById(userId : UUID) : Result<User>
    suspend fun getUsers() : Result<List<User>>
    suspend fun createUser(user : User) : Result<ResponseBody>

}