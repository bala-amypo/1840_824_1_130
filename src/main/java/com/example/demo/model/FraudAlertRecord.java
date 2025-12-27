package com.example.demo.model;

public class FraudAlertRecord {
    private Long id;
    private String alertCode;
    private String description;
    private boolean resolved;

    public FraudAlertRecord() {}

    public FraudAlertRecord(Long id, String alertCode, String description, boolean resolved) {
        this.id = id;
        this.alertCode = alertCode;
        this.description = description;
        this.resolved = resolved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlertCode() {
        return alertCode;
    }

    public void setAlertCode(String alertCode) {
        this.alertCode = alertCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
