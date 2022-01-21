package com.thussey.photobomb.data.repository.photo

import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession
import retrofit2.Response

interface PhotoRepository {

    suspend fun getPhotoSessions() : Response<List<PhotoSession>>
    suspend fun getPhotos() : Response<List<Photo>>

    suspend fun getPhotoSessionById(photoSessionId : String) : Response<PhotoSession>
    suspend fun getPhotoById(photoId : String) : Response<Photo>
}