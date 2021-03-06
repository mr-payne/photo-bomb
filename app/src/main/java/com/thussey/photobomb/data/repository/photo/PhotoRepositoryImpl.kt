package com.thussey.photobomb.data.repository.photo

import com.thussey.photobomb.data.Result
import com.thussey.photobomb.data.datasource.PhotoApiServices
import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.photosession.PhotoSession
import com.thussey.photobomb.data.retrofit.PhotoBombService
import com.thussey.photobomb.di.DispatcherModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import java.io.IOException
import java.util.*
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoApiServices : PhotoBombService<PhotoApiServices>,
    @DispatcherModule.IODispatcher private val ioDispatcher : CoroutineDispatcher) : PhotoRepository {

    private val tag = PhotoRepositoryImpl::class.java.simpleName

    override suspend fun getPhotoSessions(userId : UUID): Flow<Result<List<PhotoSession>>> {
        return withContext(ioDispatcher) {
            flow {
                try {
                    val response = photoApiServices.retrofitInstance.getPhotoSessions(userId)
                    if (response.isSuccessful) {
                        val data = response.body()
                        if (data != null) {
                            emit(Result.Success(data))
                        } else {
                            throw IOException("$tag : Data is null")
                        }
                    } else {
                        throw IOException(response.errorBody().toString())
                    }
                } catch (e: Exception) {
                    emit(Result.Error(e))
                }
            }
        }
    }

    override suspend fun getPhotos(photoSessionId : UUID): Flow<Result<List<Photo>>> {
        return withContext(ioDispatcher) {
            flow {
                try {
                    val response = photoApiServices.retrofitInstance.getPhotos(photoSessionId)
                    if (response.isSuccessful) {
                        val data = response.body()
                        if (data != null) {
                            emit(Result.Success(data))
                        } else {
                            throw IOException("$tag, data is null in getPhotos")
                        }
                    } else {
                        throw IOException(response.errorBody().toString())
                    }
                } catch (e : Exception) {
                    emit(Result.Error(e))
                }
            }
        }
    }

    override suspend fun updatePhoto(photo : Photo) : Flow<Result<ResponseBody>>{
        return withContext(ioDispatcher) {
            flow {
                try {
                    val response = photoApiServices.retrofitInstance.updatePhoto(photo.id, photo)
                    if (response.isSuccessful) {
                        val data = response.body()
                        if (data != null) {
                            emit(Result.Success(data))
                        } else {
                            throw IOException("$tag : Data is null in updatePhoto")
                        }
                    } else {
                        throw IOException(response.errorBody().toString())
                    }
                } catch (e : Exception) {
                    emit(Result.Error(e))
                }
            }
        }
    }

    override suspend fun getUserPhotos(userId: UUID): Flow<Result<List<Photo>>> {
      return withContext(ioDispatcher) {
            flow {
                try {
                    val response = photoApiServices.retrofitInstance.getUserPhotos(userId)
                    if (response.isSuccessful) {
                        val data = response.body()
                        if (data != null) {
                            emit(Result.Success(data))
                        } else {
                            throw IOException("$tag : Data is null in getUserPhotos")
                        }
                    } else {
                        throw IOException(response.errorBody().toString())
                    }
                } catch (e : Exception) {
                    emit(Result.Error(e))
                }
            }
        }
    }

    override suspend fun getPhotoById(photoId: UUID): Flow<Result<Photo>> {
        return withContext(ioDispatcher) {
            flow {
                try {
                    val response = photoApiServices.retrofitInstance.getPhotoById(photoId)
                    if (response.isSuccessful) {
                        val data = response.body()
                        if (data != null) {
                            emit(Result.Success(data))
                        } else {
                            throw IOException("$tag : Data is null in createPhotoSession")
                        }
                    } else {
                        throw IOException(response.errorBody().toString())
                    }
                } catch (e: Exception) {
                    emit(Result.Error(e))
                }
            }
        }
    }

    override suspend fun createPhotoSession(photoSession: PhotoSession) {
        return withContext(ioDispatcher) {
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
        return withContext(ioDispatcher) {
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