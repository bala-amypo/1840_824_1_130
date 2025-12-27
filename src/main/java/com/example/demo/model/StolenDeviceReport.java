package com.example.demo.model;

public class StolenDeviceReport {
    private Long id;
    private String serialNumber;
    private String description;

    public StolenDeviceReport() {}

    public StolenDeviceReport(Long id, String serialNumber, String description) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
