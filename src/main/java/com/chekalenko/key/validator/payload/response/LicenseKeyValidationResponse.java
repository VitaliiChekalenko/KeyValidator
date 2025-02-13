package com.chekalenko.key.validator.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LicenseKeyValidationResponse {
    private boolean validated;
    private String message;
}
