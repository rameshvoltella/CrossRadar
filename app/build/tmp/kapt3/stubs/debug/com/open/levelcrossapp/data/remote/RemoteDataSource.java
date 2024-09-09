package com.open.levelcrossapp.data.remote;

import com.open.levelcrossapp.data.Resource;
import com.open.levelcrossapp.data.dto.TrainInStation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/open/levelcrossapp/data/remote/RemoteDataSource;", "", "getTrainByStation", "Lcom/open/levelcrossapp/data/Resource;", "Lcom/open/levelcrossapp/data/dto/TrainInStation;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface RemoteDataSource {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTrainByStation(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.open.levelcrossapp.data.Resource<com.open.levelcrossapp.data.dto.TrainInStation>> $completion);
}