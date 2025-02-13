package com.chekalenko.key.validator.repos;


import com.chekalenko.key.validator.data.entity.LicenseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LicenseKeyRepository extends JpaRepository<LicenseKey, Long> {

    Optional<LicenseKey> findByLicense(String licenseKey);

    @Modifying
    @Query("DELETE FROM LicenseKey")
    void deleteAllEntries();
}
