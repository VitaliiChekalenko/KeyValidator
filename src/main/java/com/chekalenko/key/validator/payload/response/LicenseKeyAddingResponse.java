package com.chekalenko.key.validator.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LicenseKeyAddingResponse {
    private String message;
    private boolean isAdded;
}
