package com.example.demo.model;

public class DeviceOwnershipRecord {
    private Long id;
    private String serialNumber;
    private String ownerName;
    private boolean active;

    public DeviceOwnershipRecord() {}

    public DeviceOwnershipRecord(Long id, String serialNumber, String ownerName, boolean active) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.ownerName = ownerName;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
