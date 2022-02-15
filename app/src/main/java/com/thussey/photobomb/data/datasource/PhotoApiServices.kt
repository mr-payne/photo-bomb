package com.thussey.photobomb.data.datasource

import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession
import com.thussey.photobomb.data.model.user.User
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
import java.util.*

/**
 * Retrofit interface 
 */
interface PhotoApiServices {

    @Headers("Accept: application/json")
    @GET("/photo-sessions")
    suspend fun getPhotoSessions( //Tested
        @Query("userId") userId : UUID
    ) : Response<List<PhotoSession>>

    @Headers("Accept: application/json")
    @POST("/photo-sessions")
    suspend fun createPhotoSession( //Tested
        @Body photoSession : PhotoSession
    ) : Response<ResponseBody>

    @Headers("Accept: application/json")
    @GET("/photo-sessions/{id}/photos")
    suspend fun getPhotos( //Tested
        @Path("id") photoSessionId : UUID
    ) : Response<List<Photo>>

    @Headers("Accept: application/json")
    @GET("/photo-sessions/{photoSessionId}")
    suspend fun getPhotoSessionById(
        @Path("photoSessionId") photoSessionId : UUID
    ) : Response<PhotoSession>

    @Headers("Accept: application/json")
    @POST("/photos")
    suspend fun createPhoto( //Tested
        @Body photo : Photo
    ) : Response<ResponseBody>

    @Headers("Accept: application/json")
    @GET("/photos")
    suspend fun getUserPhotos(
        @Query("userId") userId : UUID,
        @Query("favorite") favorite : Boolean
        ) : Response<List<Photo>>

    @Headers("Accept: application/json")
    @PUT("/photos/{id}")
    suspend fun updatePhoto(
        @Path("id") photoId : UUID,
        @Body photo : Photo,
    ) : Response<ResponseBody>


    @Headers("Accept: application/json")
    @GET("/photos/{id}") //Tested
    suspend fun getPhotoById(
        @Path("id") photoId : UUID
    ) : Response<Photo>

    //Todo: remove this endpiont, only useful for testing
    @Headers("Accept: application/json")
    @GET("/users")
    suspend fun getUsers() : Response<List<User>> //Tested

    @Headers("Accept: application/json")
    @POST("/users")
    suspend fun createUser( //Tested
        @Body user: User
    ) : Response<ResponseBody>

    @Headers("Accept: application/json")
    @GET("/users/{userId}")
    suspend fun getUserById( //Tested have to manually use email in lambda
        @Path("userId") userId : UUID
    ) : Response<User>

}