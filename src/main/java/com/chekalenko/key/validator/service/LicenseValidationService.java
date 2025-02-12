package com.chekalenko.key.validator.service;

import com.chekalenko.key.validator.payload.response.LicenseKeyAddingResponse;
import com.chekalenko.key.validator.payload.request.LicenseRequest;
import com.chekalenko.key.validator.data.entity.LicenseKey;
import com.chekalenko.key.validator.payload.response.LicenseKeyValidationResponse;
import com.chekalenko.key.validator.repos.LicenseKeyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class LicenseValidationService {

    private final LicenseKeyRepository licenseRepository;

    public LicenseKeyValidationResponse validateLicenseKey(String key) {
        return getLicenseKeyValidationResponse(licenseRepository.findByLicense(key).isPresent());
    }

    private LicenseKeyValidationResponse getLicenseKeyValidationResponse(boolean isValid) {
        return isValid ? LicenseKeyValidationResponse.builder().validated(true).message("License key is valid.").build()
            : LicenseKeyValidationResponse.builder().validated(false).message("Invalid license key.").build();
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
        if (licenseRepository.findByLicense(license.getLicenseKey()).isPresent()) {
            return LicenseKeyAddingResponse.builder()
                    .isAdded(false)
                    .message("Key already exist")
                    .build();
        }

        LicenseKey licenseKey = new LicenseKey();

        licenseKey.setLicense(license.getLicenseKey());
        licenseKey.setActivated(false);
        licenseKey.setActive(true);
        licenseKey.setExpireDate(LocalDate.now().plusDays(2));
        licenseRepository.save(licenseKey);
        return LicenseKeyAddingResponse.builder()
                .isAdded(true)
                .message("License key added successfully.")
                .build();
    }
}