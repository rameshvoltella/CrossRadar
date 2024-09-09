package com.open.levelcrossapp.data.remote;

import com.open.levelcrossapp.data.NetworkConnectivity;
import com.open.levelcrossapp.data.Resource;
import com.open.levelcrossapp.data.dto.TrainInStation;
import com.open.levelcrossapp.data.remote.api.ApiServices;
import com.open.levelcrossapp.data.remote.api.ServiceGenerator;
import retrofit2.Response;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ5\u0010\r\u001a\u0004\u0018\u00010\u000e2 \u0010\u000f\u001a\u001c\b\u0001\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/open/levelcrossapp/data/remote/RemoteData;", "Lcom/open/levelcrossapp/data/remote/RemoteDataSource;", "serviceGenerator", "Lcom/open/levelcrossapp/data/remote/api/ServiceGenerator;", "networkConnectivity", "Lcom/open/levelcrossapp/data/NetworkConnectivity;", "(Lcom/open/levelcrossapp/data/remote/api/ServiceGenerator;Lcom/open/levelcrossapp/data/NetworkConnectivity;)V", "getTrainByStation", "Lcom/open/levelcrossapp/data/Resource;", "Lcom/open/levelcrossapp/data/dto/TrainInStation;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCall", "", "responseCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RemoteData implements com.open.levelcrossapp.data.remote.RemoteDataSource {
    @org.jetbrains.annotations.NotNull
    private final com.open.levelcrossapp.data.remote.api.ServiceGenerator serviceGenerator = null;
    @org.jetbrains.annotations.NotNull
    private final com.open.levelcrossapp.data.NetworkConnectivity networkConnectivity = null;
    
    @javax.inject.Inject
    public RemoteData(@org.jetbrains.annotations.NotNull
    com.open.levelcrossapp.data.remote.api.ServiceGenerator serviceGenerator, @org.jetbrains.annotations.NotNull
    com.open.levelcrossapp.data.NetworkConnectivity networkConnectivity) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getTrainByStation(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.open.levelcrossapp.data.Resource<com.open.levelcrossapp.data.dto.TrainInStation>> $completion) {
        return null;
    }
    
    private final java.lang.Object processCall(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super retrofit2.Response<?>>, ? extends java.lang.Object> responseCall, kotlin.coroutines.Continuation<java.lang.Object> $completion) {
        return null;
    }
}