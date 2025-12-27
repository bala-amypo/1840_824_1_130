package com.example.demo.model;

public class WarrantyClaimRecord {
    private Long id;
    private String serialNumber;
    private String claimReason;
    private String status;

    public WarrantyClaimRecord() {
    }

    public WarrantyClaimRecord(Long id, String serialNumber, String claimReason, String status) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.claimReason = claimReason;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getClaimReason() { return claimReason; }
    public void setClaimReason(String claimReason) { this.claimReason = claimReason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
