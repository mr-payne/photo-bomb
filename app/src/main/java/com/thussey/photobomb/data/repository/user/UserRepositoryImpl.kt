package com.thussey.photobomb.data.repository.user

import com.thussey.photobomb.data.Result
import com.thussey.photobomb.data.datasource.PhotoApiServices
import com.thussey.photobomb.data.model.user.User
import com.thussey.photobomb.data.retrofit.PhotoBombService
import com.thussey.photobomb.di.DispatcherModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import java.io.IOException
import java.util.*
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val photoApiServices : PhotoBombService<PhotoApiServices>,
    @DispatcherModule.IODispatcher private val ioDispatcher : CoroutineDispatcher) : UserRepository {
    private val tag = UserRepositoryImpl::class.java.simpleName

    override suspend fun getUserById(userId : UUID): Result<User> {
        return withContext(ioDispatcher) {
            try {
                val response = photoApiServices.retrofitInstance.getUserById(userId)
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        Result.Success(data)
                    } else {
                        throw IOException("$tag : Data is null")
                    }
                } else {
                    throw IOException(response.errorBody().toString())
                }
            } catch (e : Exception) {
                Result.Error(e)
            }
        }
    }

    override suspend fun getUsers(): Result<List<User>> {
        // Try catch block to handle exceptions when calling the API.
        return withContext(ioDispatcher) {
            try {
                val response = photoApiServices.retrofitInstance.getUsers()
                // Check if response was successful.
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        Result.Success(data)
                    } else {
                        throw IOException("$tag : Data is null")
                    }
                } else {
                    throw IOException(response.errorBody().toString())
                }
            } catch (e: Exception){
                Result.Error(e)
            }
        }
    }

    override suspend fun createUser(user: User): Result<ResponseBody> {
        return withContext(ioDispatcher) {
            try {
                val response = photoApiServices.retrofitInstance.createUser(user)
                // Check if response was successful.
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        Result.Success(data)
                    } else {
                        throw IOException("$tag : Data is null")
                    }
                } else {
                    throw IOException(response.errorBody().toString())
                }
            } catch (e: Exception){
                Result.Error(e)
            }
        }
    }
}