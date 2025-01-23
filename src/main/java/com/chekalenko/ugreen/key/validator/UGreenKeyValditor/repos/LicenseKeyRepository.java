package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.repos;


import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.model.LicenseKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LicenseKeyRepository extends JpaRepository<LicenseKey, Long> {
    // Метод для пошуку ліцензійного ключа за значенням
    Optional<LicenseKey> findByLicenseKey(String licenseKey);
}
