package com.example.demo.model;

public class StolenDeviceReport {
    private Long id;
    private String serialNumber;
    private String reporterName;
    private String reportReason;

    public StolenDeviceReport() {
    }

    public StolenDeviceReport(Long id, String serialNumber, String reporterName, String reportReason) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.reporterName = reporterName;
        this.reportReason = reportReason;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getReporterName() { return reporterName; }
    public void setReporterName(String reporterName) { this.reporterName = reporterName; }

    public String getReportReason() { return reportReason; }
    public void setReportReason(String reportReason) { this.reportReason = reportReason; }
}
