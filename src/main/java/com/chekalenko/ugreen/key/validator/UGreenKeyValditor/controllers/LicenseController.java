package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.controllers;


import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.model.LicenseKey;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.repos.LicenseKeyRepository;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.service.LicenseValidationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/api/licenses")
public class LicenseController {

    private final LicenseValidationService licenseValidationService;
    private final LicenseKeyRepository licenseRepository;

    @PostMapping("/validate")
    public ResponseEntity<String> validateLicense(@RequestBody LicenseRequest licenseRequest) {
        String isValid = licenseValidationService.validateLicenseKey(licenseRequest.getKey());
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLicenseKey(@RequestBody LicenseKey license) {
        try {
            LicenseKey key = new LicenseKey();
            key.setLicenseKey(license.getLicenseKey());
            key.setActivated(false);
            key.setActive(true);
            key.setExpDate(LocalDate.now().plusDays(2));
            licenseRepository.save(license);
        } catch (Exception e) {
            if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("License key already exists: " + license.getLicenseKey());
            }
        }
        return ResponseEntity.ok("License key added successfully.");
    }

    @PostMapping("/clearDB")
    public ResponseEntity<String> clearDB() {
        return ResponseEntity.ok(licenseValidationService.clearAllLicenses());
    }
}