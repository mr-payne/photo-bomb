package com.thussey.photobomb.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
class DispatcherModule {

    @DefaultDispatcher
    @Provides
    fun provideDefaultDispatcher() : CoroutineDispatcher = Dispatchers.Default

    @IODispatcher
    @Provides
    fun provideIODispatcher() : CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun provideMainDispatcher() : CoroutineDispatcher = Dispatchers.Main

    @Retention
    @Qualifier
    annotation class DefaultDispatcher

    @Retention
    @Qualifier
    annotation class IODispatcher

    @Retention
    @Qualifier
    annotation class MainDispatcher
}