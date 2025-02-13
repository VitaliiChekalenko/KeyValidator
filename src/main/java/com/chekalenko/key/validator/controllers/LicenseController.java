package com.chekalenko.key.validator.controllers;


import com.chekalenko.key.validator.payload.response.LicenseKeyAddingResponse;
import com.chekalenko.key.validator.payload.response.LicenseKeyValidationResponse;
import com.chekalenko.key.validator.payload.response.SuccessResponse;
import com.chekalenko.key.validator.payload.request.LicenseRequest;
import com.chekalenko.key.validator.service.LicenseValidationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/licenses")
public class LicenseController {

    private final LicenseValidationService licenseValidationService;

    @PostMapping("/validate")
    public ResponseEntity<SuccessResponse<LicenseKeyValidationResponse>> validateLicense(@RequestBody LicenseRequest licenseRequest) {
        return ResponseEntity.ok(new SuccessResponse<>(
            licenseValidationService.validateLicenseKey(licenseRequest.getLicenseKey())));

    }

    @PostMapping("/add")
    public ResponseEntity<SuccessResponse<LicenseKeyAddingResponse>> addLicenseKey(@RequestBody LicenseRequest license) {
        return ResponseEntity.ok(new SuccessResponse<>(licenseValidationService.addLicenseKey(license)));
    }

    @PostMapping("/clearDB")
    public ResponseEntity<String> clearDB() {
        return ResponseEntity.ok(licenseValidationService.clearAllLicenses());
    }
}