package com.thussey.photobomb.data.datasource

import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession
import com.thussey.photobomb.data.model.user.User
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoApiServices {
    @GET("users/{userId}/photo-sessions")
    fun getPhotoSessions() : Single<List<PhotoSession>>

    @GET("users/{userId}/photos")
    fun getPhotos() : Single<List<Photo>>

    @GET("photoSessions/{photoSessionId}")
    fun getPhotoSessionById() : Single<PhotoSession>

    @GET("photos/{photoId}")
    fun getPhotoById() : Single<Photo>

    @GET("/users")
    fun getUsers() : Call<List<User>>

    @GET("/useres/{id}")
    fun getUserById() : Single<User>

}