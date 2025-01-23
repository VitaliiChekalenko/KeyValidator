package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.service;

import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.model.LicenseKey;
import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.repos.LicenseKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LicenseValidationService {

    @Autowired
    private LicenseKeyRepository licenseRepository;

    public boolean validateLicenseKey(String key) {
        Optional<LicenseKey> byLicenseKey = licenseRepository.findByLicenseKey(key);
        return !byLicenseKey.isEmpty();
    }
}