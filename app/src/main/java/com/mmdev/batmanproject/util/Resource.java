package com.mmdev.batmanproject.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/**
 * this class used for managing stats of responses that comes from Web.
 *
 * @author Mohammad Mirdar
 * @version 1.0
 * @since 2020-09-28
 */
public class Resource<T> {

    @NonNull
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;

    public Resource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    public static <T> Resource<T> error(@NonNull String msg, @Nullable T data) {
        return new Resource<>(Status.ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(Status.LOADING, data, null);
    }

    public enum Status { SUCCESS, ERROR, LOADING}
}
