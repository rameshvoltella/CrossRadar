package com.open.levelcrossapp.errors.mapper;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0004H&R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/open/levelcrossapp/errors/mapper/ErrorMapperSource;", "", "errorsMap", "", "", "", "getErrorsMap", "()Ljava/util/Map;", "getErrorString", "errorId", "app_debug"})
public abstract interface ErrorMapperSource {
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getErrorString(int errorId);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.Map<java.lang.Integer, java.lang.String> getErrorsMap();
}