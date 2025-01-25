package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.common;

import lombok.Data;

@Data
public class SuccessResponse<T> {
    T data;

    public SuccessResponse(T data) {
        this.data = data;
    }
}
