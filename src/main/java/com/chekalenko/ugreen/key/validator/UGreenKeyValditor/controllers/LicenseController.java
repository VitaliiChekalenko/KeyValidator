package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.controllers;


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
    public ResponseEntity<String> addLicenseKey(@RequestBody LicenseKey license) {
        licenseValidationService.addLicenseKey(license);
        return ResponseEntity.ok("License key added successfully.");
    }

    @PostMapping("/clearDB")
    public ResponseEntity<String> clearDB() {
        return ResponseEntity.ok(licenseValidationService.clearAllLicenses());
    }
}