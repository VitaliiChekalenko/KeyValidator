package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.service;

import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.payload.response.LicenseKeyAddingResponse;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.payload.request.LicenseRequest;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.model.LicenseKey;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.payload.response.LicenseKeyValidationResponse;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.repos.LicenseKeyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class LicenseValidationService {

    private final LicenseKeyRepository licenseRepository;

    public LicenseKeyValidationResponse validateLicenseKey(String key) {
        return getLicenseKeyValidationResponse(licenseRepository.findByLicenseKey(key).isPresent());
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
        if (licenseRepository.findByLicenseKey(license.getLicenseKey().toString()).isPresent()) {
            return LicenseKeyAddingResponse.builder()
                    .isAdded(false)
                    .message("Key already exist")
                    .build();
        }

        LicenseKey licenseKey = new LicenseKey();

        licenseKey.setLicenseKey(license.getLicenseKey().toString());
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