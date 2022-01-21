package com.thussey.photobomb.data.datasource

import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession
import com.thussey.photobomb.data.model.user.User
import retrofit2.Response
import retrofit2.http.GET

interface PhotoApiServices {
    @GET("users/{userId}/photo-sessions")
    fun getPhotoSessions() : Response<List<PhotoSession>>

    @GET("users/{userId}/photos")
    fun getPhotos() : Response<List<Photo>>

    @GET("photoSessions/{photoSessionId}")
    fun getPhotoSessionById() : Response<PhotoSession>

    @GET("photos/{photoId}")
    fun getPhotoById() : Response<Photo>

    @GET("/users")
    suspend fun getUsers() : Response<List<User>>

    @GET("/useres/{id}")
    fun getUserById() : Response<User>

}