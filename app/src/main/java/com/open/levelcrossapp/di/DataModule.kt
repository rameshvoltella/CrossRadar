package com.open.levelcrossapp.di


import com.open.levelcrossapp.data.remote.RemoteRepository
import com.open.levelcrossapp.data.remote.RemoteRepositorySource

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Tells Dagger this is a Dagger module
@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {




    @Binds
    @Singleton
    abstract fun provideRemoteRepository(remoteRepository: RemoteRepository): RemoteRepositorySource


}