package com.thussey.photobomb.data.repository.photo

import com.thussey.photobomb.data.Result
import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession
import kotlinx.coroutines.flow.Flow
import java.util.*

interface PhotoRepository {

    suspend fun getPhotoSessions(userId : UUID) : Flow<Result<List<PhotoSession>>>
    suspend fun createPhotoSession(photoSession : PhotoSession)

    suspend fun getPhotos(photoSessionId : UUID) : Flow<Result<List<Photo>>>
    suspend fun getPhotoById(photoId : UUID) : Flow<Result<Photo>>
    suspend fun getUserPhotos(userId : UUID, favorite : Boolean) : Flow<Result<List<Photo>>>
    suspend fun createPhoto(photo : Photo)
}