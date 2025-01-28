package com.excel.socket.core.response;

import lombok.Builder;

@Builder
public record Response<T>(T data, Boolean isError, String message) {
}
