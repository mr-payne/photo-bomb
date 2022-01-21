package com.thussey.photobomb.data.repository.user

import com.thussey.photobomb.data.Result
import com.thussey.photobomb.data.datasource.PhotoApiServices
import com.thussey.photobomb.data.model.user.User
import com.thussey.photobomb.data.retrofit.PhotoBombService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    val photoApiServices : PhotoBombService<PhotoApiServices>) : UserRepository {
    val tag = UserRepositoryImpl::class.java.simpleName

    override suspend fun getUserById(): Result<User> {
        TODO("Not yet implemented")
    }

    override suspend fun getUsers(): Result<List<User>> {
        // Try catch block to handle exceptions when calling the API.
        return withContext(Dispatchers.IO) {
            try {
                val response = photoApiServices.retrofitInstance.getUsers()
                // Check if response was successful.
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()
                    Result.Success(data!!)
                } else {
                    throw IOException("")
                }
            } catch (e: Exception){
                Result.Error(e)
            }
        }

    }
}