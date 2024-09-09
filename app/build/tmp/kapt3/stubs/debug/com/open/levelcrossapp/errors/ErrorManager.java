package com.open.levelcrossapp.errors;

import com.open.levelcrossapp.errors.mapper.ErrorMapper;
import javax.inject.Inject;

/**
 * This ERROR manager class
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/open/levelcrossapp/errors/ErrorManager;", "Lcom/open/levelcrossapp/errors/ErrorUseCase;", "errorMapper", "Lcom/open/levelcrossapp/errors/mapper/ErrorMapper;", "(Lcom/open/levelcrossapp/errors/mapper/ErrorMapper;)V", "getError", "Lcom/open/levelcrossapp/errors/Error;", "errorCode", "", "app_debug"})
public final class ErrorManager implements com.open.levelcrossapp.errors.ErrorUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.open.levelcrossapp.errors.mapper.ErrorMapper errorMapper = null;
    
    @javax.inject.Inject
    public ErrorManager(@org.jetbrains.annotations.NotNull
    com.open.levelcrossapp.errors.mapper.ErrorMapper errorMapper) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.open.levelcrossapp.errors.Error getError(int errorCode) {
        return null;
    }
}