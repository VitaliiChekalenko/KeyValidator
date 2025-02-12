package com.chekalenko.key.validator.payload.request;

import lombok.Data;

import java.util.UUID;

@Data
public class LicenseKeyRequest {
    private UUID licenseKey;
}
