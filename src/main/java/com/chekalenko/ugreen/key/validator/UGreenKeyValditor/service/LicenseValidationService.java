package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.service;

import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.common.LicenseKeyAddingResponse;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.controllers.LicenseRequest;
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
        return "DB had been cleared";
    }

    public LicenseKeyAddingResponse addLicenseKey(LicenseRequest license) {
        if (licenseRepository.findByLicenseKey(license.getKey()).isPresent()) {
            return LicenseKeyAddingResponse.builder()
                    .isAdded(false)
                    .message("Key already exist")
                    .build();
        }

        LicenseKey licenseKey = new LicenseKey();

        licenseKey.setLicenseKey(license.getKey());
        licenseKey.setActivated(false);
        licenseKey.setActive(true);
        licenseKey.setExpDate(LocalDate.now().plusDays(2));
        licenseRepository.save(licenseKey);
        return LicenseKeyAddingResponse.builder()
                .isAdded(true)
                .message("License key added successfully.")
                .build();
    }
}