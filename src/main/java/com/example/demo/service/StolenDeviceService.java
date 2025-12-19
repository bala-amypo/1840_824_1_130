package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.StolenDevice;

public interface StolenDeviceService


{
    public StolenDevice reportStolen(StolenDevice report);
    public StolenDevice getReportsBySerial(StolenDevice serialNumber);
    public StolenDevice getReportById(StolenDevice id);
    public StolenDevice getAllReports();
}