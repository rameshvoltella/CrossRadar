package com.open.levelcrossapp.data.remote;

import com.open.levelcrossapp.data.Resource;
import com.open.levelcrossapp.data.dto.TrainInStation;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/open/levelcrossapp/data/remote/RemoteRepository;", "Lcom/open/levelcrossapp/data/remote/RemoteRepositorySource;", "remoteRepository", "Lcom/open/levelcrossapp/data/remote/RemoteData;", "(Lcom/open/levelcrossapp/data/remote/RemoteData;)V", "getTrainByStation", "Lkotlinx/coroutines/flow/Flow;", "Lcom/open/levelcrossapp/data/Resource;", "Lcom/open/levelcrossapp/data/dto/TrainInStation;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RemoteRepository implements com.open.levelcrossapp.data.remote.RemoteRepositorySource {
    @org.jetbrains.annotations.NotNull
    private final com.open.levelcrossapp.data.remote.RemoteData remoteRepository = null;
    
    @javax.inject.Inject
    public RemoteRepository(@org.jetbrains.annotations.NotNull
    com.open.levelcrossapp.data.remote.RemoteData remoteRepository) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getTrainByStation(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.open.levelcrossapp.data.Resource<com.open.levelcrossapp.data.dto.TrainInStation>>> $completion) {
        return null;
    }
}