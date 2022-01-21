package com.thussey.photobomb.data.repository.photo

import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession

interface PhotoRepository {

    fun getPhotoSessions() : Result<List<PhotoSession>>
    fun getPhotos() : Result<List<Photo>>

    fun getPhotoSessionById(photoSessionId : String) : Result<PhotoSession>
    fun getPhotoById(photoId : String) : Result<Photo>
}