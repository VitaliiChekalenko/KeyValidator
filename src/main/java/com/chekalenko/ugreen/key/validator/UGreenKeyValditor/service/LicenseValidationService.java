package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.service;

import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.model.LicenseKey;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.repos.LicenseKeyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class LicenseValidationService {

    private final LicenseKeyRepository licenseRepository;

    public String validateLicenseKey(String key) {
        return licenseRepository.findByLicenseKey(key).isPresent() ?
                "License key is valid." : "Invalid license key.";
    }

    public String clearAllLicenses() {
        try {
            licenseRepository.deleteAllEntries();
        } catch (Exception e) {
            return e.getMessage();
        }
        return "DB is cleared";
    }

    public void addLicenseKey(LicenseKey license) {
        if (licenseRepository.findByLicenseKey(license.getLicenseKey()).isPresent()) {
            throw new RuntimeException("Key already exist");
        }

        license.setLicenseKey(license.getLicenseKey());
        license.setActivated(false);
        license.setActive(true);
        license.setExpDate(LocalDate.now().plusDays(2));
        licenseRepository.save(license);
    }
}