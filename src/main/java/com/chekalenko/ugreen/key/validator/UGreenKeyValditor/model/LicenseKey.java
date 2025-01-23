package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "license_keys")
public class LicenseKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String licenseKey;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private boolean isActivated;

    @Column(nullable = false)
    private LocalDate expDate;
}