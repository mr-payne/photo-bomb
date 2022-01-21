package com.thussey.photobomb.data.repository.photo

import com.thussey.photobomb.data.retrofit.PhotoBombService
import com.thussey.photobomb.data.datasource.PhotoApiServices
import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession
import java.util.*
import javax.inject.Inject

class PhotoRepositoryImpl  @Inject constructor(
    val photoApiServices : PhotoBombService<PhotoApiServices>) : PhotoRepository {
    override fun getPhotoSessions(): MutableList<PhotoSession> {
        val threeMockSessions = mutableListOf<PhotoSession>()
        threeMockSessions.add(PhotoSession("1", "title 1", Date(), "thumbnail"))
        threeMockSessions.add(PhotoSession("2", "title 2", Date(), "thumbnaila"))
        threeMockSessions.add(PhotoSession("3", "title 3", Date(), "thumbnailb"))
        return threeMockSessions
    }

    override fun getPhotos(): MutableList<Photo> {
        TODO("Not yet implemented")
    }

    override fun getPhotoSessionById(photoSessionId: String): PhotoSession {
        TODO("Not yet implemented")
    }

    override fun getPhotoById(photoId: String): Photo {
        TODO("Not yet implemented")
    }

}