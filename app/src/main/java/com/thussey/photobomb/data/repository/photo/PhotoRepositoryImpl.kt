package com.thussey.photobomb.data.repository.photo

import com.thussey.photobomb.data.datasource.PhotoApiServices
import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession
import com.thussey.photobomb.data.retrofit.PhotoBombService
import javax.inject.Inject

class PhotoRepositoryImpl  @Inject constructor(
    val photoApiServices : PhotoBombService<PhotoApiServices>) : PhotoRepository {
    override fun getPhotoSessions(): Result<List<PhotoSession>> {
        TODO("Not yet implemented")

    }

    override fun getPhotos(): Result<List<Photo>> {
        TODO("Not yet implemented")
    }

    override fun getPhotoSessionById(photoSessionId: String): Result<PhotoSession> {
        TODO("Not yet implemented")
    }

    override fun getPhotoById(photoId: String): Result<Photo> {
        TODO("Not yet implemented")
    }

}