package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.service;

import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.repos.LicenseKeyRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LicenseValidationService {

    private final LicenseKeyRepository licenseRepository;

    public String validateLicenseKey(String key) {
        boolean isValid = licenseRepository.findByLicenseKey(key).isPresent();
        return isValid ? "License key is valid." : "Invalid license key.";
    }

    @Transactional
    public String clearAllLicenses() {
        try {
            licenseRepository.deleteAllEntries();
        } catch (Exception e) {
            return e.getMessage();
        }
        return "DB is cleared";
    }
}