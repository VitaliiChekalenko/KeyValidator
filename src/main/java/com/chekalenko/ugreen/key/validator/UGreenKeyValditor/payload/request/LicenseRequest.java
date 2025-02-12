package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.payload.request;

import lombok.Data;
import java.util.UUID;

@Data
public class LicenseRequest {
    private UUID licenseKey;
}