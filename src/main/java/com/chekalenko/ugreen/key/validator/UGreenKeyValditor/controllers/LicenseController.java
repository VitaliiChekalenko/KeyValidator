package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.controllers;


import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.model.LicenseKey;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.repos.LicenseKeyRepository;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.service.LicenseValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/licenses")
public class LicenseController {

    @Autowired
    private LicenseValidationService licenseValidationService;
    @Autowired
    private LicenseKeyRepository licenseRepository;

    @PostMapping("/validate")
    public ResponseEntity<String> validateLicense(@RequestBody LicenseRequest licenseRequest) {
        boolean isValid = licenseValidationService.validateLicenseKey(licenseRequest.getKey());
        if (isValid) {
            return ResponseEntity.ok("License key is valid.");
        } else {
            return ResponseEntity.status(400).body("Invalid license key.");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLicenseKey(@RequestBody LicenseKey license) {
        licenseRepository.save(license);
        return ResponseEntity.ok("License key added successfully.");
    }
}