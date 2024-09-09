package com.open.levelcrossapp.di;

import com.open.levelcrossapp.data.remote.RemoteRepository;
import com.open.levelcrossapp.data.remote.RemoteRepositorySource;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/open/levelcrossapp/di/DataModule;", "", "()V", "provideRemoteRepository", "Lcom/open/levelcrossapp/data/remote/RemoteRepositorySource;", "remoteRepository", "Lcom/open/levelcrossapp/data/remote/RemoteRepository;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class DataModule {
    
    public DataModule() {
        super();
    }
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract com.open.levelcrossapp.data.remote.RemoteRepositorySource provideRemoteRepository(@org.jetbrains.annotations.NotNull
    com.open.levelcrossapp.data.remote.RemoteRepository remoteRepository);
}