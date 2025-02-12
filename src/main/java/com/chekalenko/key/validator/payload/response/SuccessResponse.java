package com.chekalenko.key.validator.payload.response;

import lombok.Data;

@Data
public class SuccessResponse<T> {
    T data;

    public SuccessResponse(T data) {
        this.data = data;
    }
}
