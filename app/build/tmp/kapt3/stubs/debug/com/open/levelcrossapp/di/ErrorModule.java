package com.open.levelcrossapp.di;

import com.open.levelcrossapp.errors.mapper.ErrorMapper;
import com.open.levelcrossapp.errors.mapper.ErrorMapperSource;
import com.open.levelcrossapp.errors.ErrorManager;
import com.open.levelcrossapp.errors.ErrorUseCase;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/open/levelcrossapp/di/ErrorModule;", "", "()V", "provideErrorFactoryImpl", "Lcom/open/levelcrossapp/errors/ErrorUseCase;", "errorManager", "Lcom/open/levelcrossapp/errors/ErrorManager;", "provideErrorMapper", "Lcom/open/levelcrossapp/errors/mapper/ErrorMapperSource;", "errorMapper", "Lcom/open/levelcrossapp/errors/mapper/ErrorMapper;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class ErrorModule {
    
    public ErrorModule() {
        super();
    }
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract com.open.levelcrossapp.errors.ErrorUseCase provideErrorFactoryImpl(@org.jetbrains.annotations.NotNull
    com.open.levelcrossapp.errors.ErrorManager errorManager);
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract com.open.levelcrossapp.errors.mapper.ErrorMapperSource provideErrorMapper(@org.jetbrains.annotations.NotNull
    com.open.levelcrossapp.errors.mapper.ErrorMapper errorMapper);
}