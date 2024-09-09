package com.open.levelcrossapp.data.remote.api;

import android.os.Build;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0010\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/open/levelcrossapp/data/remote/api/ServiceGenerator;", "", "()V", "headerInterceptor", "Lokhttp3/Interceptor;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor;", "getLogger", "()Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpBuilder", "Lokhttp3/OkHttpClient$Builder;", "retrofit", "Lretrofit2/Retrofit;", "createService", "S", "serviceClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getDefaultUserAgent", "", "getMoshi", "Lcom/squareup/moshi/Moshi;", "app_debug"})
public final class ServiceGenerator {
    @org.jetbrains.annotations.NotNull
    private final okhttp3.OkHttpClient.Builder okHttpBuilder = null;
    @org.jetbrains.annotations.NotNull
    private retrofit2.Retrofit retrofit;
    @org.jetbrains.annotations.NotNull
    private okhttp3.Interceptor headerInterceptor;
    
    @javax.inject.Inject
    public ServiceGenerator() {
        super();
    }
    
    private final okhttp3.logging.HttpLoggingInterceptor getLogger() {
        return null;
    }
    
    public final <S extends java.lang.Object>S createService(@org.jetbrains.annotations.NotNull
    java.lang.Class<S> serviceClass) {
        return null;
    }
    
    private final com.squareup.moshi.Moshi getMoshi() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDefaultUserAgent() {
        return null;
    }
}