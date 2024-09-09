package com.open.levelcrossapp.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/open/levelcrossapp/data/NetworkConnectivity;", "", "getNetworkInfo", "Landroid/net/NetworkInfo;", "isConnected", "", "app_debug"})
public abstract interface NetworkConnectivity {
    
    @org.jetbrains.annotations.Nullable
    public abstract android.net.NetworkInfo getNetworkInfo();
    
    public abstract boolean isConnected();
}