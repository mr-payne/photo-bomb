package com.thussey.photobomb.data.repository.photo

import com.thussey.photobomb.data.Result
import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession

interface PhotoRepository {

    suspend fun getPhotoSessions(userId : String) : Result<List<PhotoSession>>
    suspend fun getPhotos() : Result<List<Photo>>

    suspend fun getPhotoSessionById(photoSessionId : String) : Result<PhotoSession>
    suspend fun getPhotoById(photoId : String) : Result<Photo>

    suspend fun createPhotoSession(photoSession : PhotoSession)
    suspend fun createPhoto(photo : Photo)
}