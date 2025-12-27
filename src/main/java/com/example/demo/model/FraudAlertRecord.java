package com.example.demo.model;

public class FraudAlertRecord {
    private Long id;
    private String serialNumber;
    private String alertType;
    private boolean resolved;

    public FraudAlertRecord() {
    }

    public FraudAlertRecord(Long id, String serialNumber, String alertType, boolean resolved) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.alertType = alertType;
        this.resolved = resolved;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getAlertType() { return alertType; }
    public void setAlertType(String alertType) { this.alertType = alertType; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
