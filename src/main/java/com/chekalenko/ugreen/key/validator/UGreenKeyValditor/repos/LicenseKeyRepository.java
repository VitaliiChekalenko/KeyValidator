package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.repos;


import com.chekalenko.ugreen.key.validator.UGreenKeyValditor.model.LicenseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LicenseKeyRepository extends JpaRepository<LicenseKey, Long> {
    Optional<LicenseKey> findByLicenseKey(String licenseKey);
    @Modifying
    @Query("DELETE FROM LicenseKey")
    void deleteAllEntries();
}
