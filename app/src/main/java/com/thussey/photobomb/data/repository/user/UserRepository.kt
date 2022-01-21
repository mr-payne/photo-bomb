package com.thussey.photobomb.data.repository.user

import com.thussey.photobomb.data.model.user.User
import io.reactivex.Single
import retrofit2.Call

interface UserRepository {

    fun getUserById() : Single<User>
    fun getUsers() : Call<List<User>>
}