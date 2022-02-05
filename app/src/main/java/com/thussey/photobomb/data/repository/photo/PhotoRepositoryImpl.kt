package com.thussey.photobomb.data.repository.photo

import com.thussey.photobomb.data.Result
import com.thussey.photobomb.data.datasource.PhotoApiServices
import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession
import com.thussey.photobomb.data.retrofit.PhotoBombService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoApiServices : PhotoBombService<PhotoApiServices>) : PhotoRepository {

    private val tag = PhotoRepositoryImpl::class.java.simpleName

    override suspend fun getPhotoSessions(userId : String): Result<List<PhotoSession>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = photoApiServices.retrofitInstance.getPhotoSessions(userId)
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        Result.Success(data)
                    } else {
                        throw IOException("$tag : Data is null")
                    }
                } else {
                    throw IOException(response.errorBody().toString())
                }
            } catch (e : Exception) {
                Result.Error(e)
            }
        }
    }

    override suspend fun getPhotos(): Result<List<Photo>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPhotoSessionById(photoSessionId: String): Result<PhotoSession> {
        TODO("Not yet implemented")
    }

    override suspend fun getPhotoById(photoId: String): Result<Photo> {
        return withContext(Dispatchers.IO) {
            try {
                val response = photoApiServices.retrofitInstance.getPhotoById(photoId)
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        Result.Success(data)
                    } else {
                        throw IOException("$tag : Data is null in createPhotoSession")
                    }
                } else {
                    throw IOException(response.errorBody().toString())
                }
            } catch (e : Exception) {
                Result.Error(e)
            }
        }
    }

    override suspend fun createPhotoSession(photoSession: PhotoSession) {
        return withContext(Dispatchers.IO) {
            try {
                val response = photoApiServices.retrofitInstance.createPhotoSession(photoSession)
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        Result.Success(data)
                    } else {
                        throw IOException("$tag : Data is null in createPhotoSession")
                    }
                } else {
                    throw IOException(response.errorBody().toString())
                }
            } catch (e : Exception) {
                Result.Error(e)
            }
        }
    }

    override suspend fun createPhoto(photo : Photo) {
        return withContext(Dispatchers.IO) {
            try {
                val response = photoApiServices.retrofitInstance.createPhoto(photo)
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        Result.Success(data)
                    } else {
                        throw IOException("$tag : Data is null in createPhoto")
                    }
                } else {
                    throw IOException(response.errorBody().toString())
                }
            } catch (e : Exception) {
                Result.Error(e)
            }
        }
    }

}