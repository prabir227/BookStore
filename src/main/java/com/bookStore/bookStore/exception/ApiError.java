package com.bookStore.bookStore.exception;

import java.time.LocalDateTime;

public record ApiError(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {}
