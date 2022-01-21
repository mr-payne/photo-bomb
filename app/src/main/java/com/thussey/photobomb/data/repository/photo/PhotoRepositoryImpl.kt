package com.thussey.photobomb.data.repository.photo

import com.thussey.photobomb.data.datasource.PhotoApiServices
import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession
import com.thussey.photobomb.data.retrofit.PhotoBombService
import retrofit2.Response
import javax.inject.Inject

class PhotoRepositoryImpl  @Inject constructor(
    val photoApiServices : PhotoBombService<PhotoApiServices>) : PhotoRepository {

    override suspend fun getPhotoSessions(): Response<List<PhotoSession>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPhotos(): Response<List<Photo>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPhotoSessionById(photoSessionId: String): Response<PhotoSession> {
        TODO("Not yet implemented")
    }

    override suspend fun getPhotoById(photoId: String): Response<Photo> {
        TODO("Not yet implemented")
    }

}