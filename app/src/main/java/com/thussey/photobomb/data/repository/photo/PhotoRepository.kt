package com.thussey.photobomb.data.repository.photo

import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession

interface PhotoRepository {

    fun getPhotoSessions() : List<PhotoSession>
    fun getPhoto() : List<Photo>

    fun getPhotoSessionById(photoSessionId : String) : PhotoSession
    fun getPhotoById(photoId : String) : Photo
}