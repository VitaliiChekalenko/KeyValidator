package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LicenseKeyValidationResponse {
    private boolean validated;
    private String message;
}
