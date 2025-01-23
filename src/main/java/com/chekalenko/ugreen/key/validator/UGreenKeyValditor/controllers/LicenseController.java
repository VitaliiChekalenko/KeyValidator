package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.controllers;


import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.common.LicenseKeyAddingResponse;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.common.SuccessResponse;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.model.LicenseKey;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.service.LicenseValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/licenses")
public class LicenseController {

    private final LicenseValidationService licenseValidationService;

    @PostMapping("/validate")
    public ResponseEntity<String> validateLicense(@RequestBody LicenseRequest licenseRequest) {
        return ResponseEntity.ok(licenseValidationService.validateLicenseKey(licenseRequest.getKey()));
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