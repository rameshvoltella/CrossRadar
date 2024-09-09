package com.open.levelcrossapp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0006\u0012\u0013\u0014\u0015\u0016\u0017B+\b\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0007H\u0016R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0006\u0018\u0019\u001a\u001b\u001c\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/open/levelcrossapp/data/Resource;", "T", "", "data", "errorCode", "", "instanceIdentifier", "", "(Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInstanceIdentifier", "()Ljava/lang/String;", "toString", "DataError", "DataErrorInstance", "Loading", "LoadingInstance", "Success", "SuccessInstance", "Lcom/open/levelcrossapp/data/Resource$DataError;", "Lcom/open/levelcrossapp/data/Resource$DataErrorInstance;", "Lcom/open/levelcrossapp/data/Resource$Loading;", "Lcom/open/levelcrossapp/data/Resource$LoadingInstance;", "Lcom/open/levelcrossapp/data/Resource$Success;", "Lcom/open/levelcrossapp/data/Resource$SuccessInstance;", "app_debug"})
public abstract class Resource<T extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable
    private final T data = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer errorCode = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String instanceIdentifier = null;
    
    private Resource(T data, java.lang.Integer errorCode, java.lang.String instanceIdentifier) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final T getData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getErrorCode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getInstanceIdentifier() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/open/levelcrossapp/data/Resource$DataError;", "T", "Lcom/open/levelcrossapp/data/Resource;", "errorCode", "", "(I)V", "app_debug"})
    public static final class DataError<T extends java.lang.Object> extends com.open.levelcrossapp.data.Resource<T> {
        
        public DataError(int errorCode) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/open/levelcrossapp/data/Resource$DataErrorInstance;", "T", "Lcom/open/levelcrossapp/data/Resource;", "errorCode", "", "instanceIdentifier", "", "(ILjava/lang/String;)V", "app_debug"})
    public static final class DataErrorInstance<T extends java.lang.Object> extends com.open.levelcrossapp.data.Resource<T> {
        
        public DataErrorInstance(int errorCode, @org.jetbrains.annotations.Nullable
        java.lang.String instanceIdentifier) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/open/levelcrossapp/data/Resource$Loading;", "T", "Lcom/open/levelcrossapp/data/Resource;", "data", "(Ljava/lang/Object;)V", "app_debug"})
    public static final class Loading<T extends java.lang.Object> extends com.open.levelcrossapp.data.Resource<T> {
        
        public Loading(@org.jetbrains.annotations.Nullable
        T data) {
        }
        
        public Loading() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/open/levelcrossapp/data/Resource$LoadingInstance;", "T", "Lcom/open/levelcrossapp/data/Resource;", "instanceIdentifier", "", "(Ljava/lang/String;)V", "app_debug"})
    public static final class LoadingInstance<T extends java.lang.Object> extends com.open.levelcrossapp.data.Resource<T> {
        
        public LoadingInstance(@org.jetbrains.annotations.NotNull
        java.lang.String instanceIdentifier) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/open/levelcrossapp/data/Resource$Success;", "T", "Lcom/open/levelcrossapp/data/Resource;", "data", "(Ljava/lang/Object;)V", "app_debug"})
    public static final class Success<T extends java.lang.Object> extends com.open.levelcrossapp.data.Resource<T> {
        
        public Success(T data) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/open/levelcrossapp/data/Resource$SuccessInstance;", "T", "Lcom/open/levelcrossapp/data/Resource;", "data", "instanceIdentifier", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "app_debug"})
    public static final class SuccessInstance<T extends java.lang.Object> extends com.open.levelcrossapp.data.Resource<T> {
        
        public SuccessInstance(T data, @org.jetbrains.annotations.Nullable
        java.lang.String instanceIdentifier) {
        }
    }
}