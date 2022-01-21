package com.thussey.photobomb.data.repository.user

import com.thussey.photobomb.data.datasource.PhotoApiServices
import com.thussey.photobomb.data.model.user.User
import com.thussey.photobomb.data.retrofit.PhotoBombService
import io.reactivex.Single
import retrofit2.Call
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    val photoApiServices : PhotoBombService<PhotoApiServices>) : UserRepository {

    override fun getUserById(): Single<User> {
        TODO("Not yet implemented")
    }

    override fun getUsers(): Call<List<User>> {
        return photoApiServices.retrofitInstance.getUsers()
    }
}