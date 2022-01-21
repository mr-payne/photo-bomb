package com.thussey.photobomb.di

import com.thussey.photobomb.data.repository.photo.PhotoRepository
import com.thussey.photobomb.data.repository.photo.PhotoRepositoryImpl
import com.thussey.photobomb.data.repository.user.UserRepository
import com.thussey.photobomb.data.repository.user.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPhotoRepositoryImpl(
        photoRepositoryImpl: PhotoRepositoryImpl
    ): PhotoRepository

    @Binds
    abstract fun bindUserRepositoryImpl(
        userRepositoryImpl : UserRepositoryImpl
    ) : UserRepository
}