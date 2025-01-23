package com.chekalenko.ugreen.key.validator.UGreenKeyValditor.controllers;

public class LicenseRequest {

    private String key;

    public LicenseRequest() {
    }

    public LicenseRequest(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}