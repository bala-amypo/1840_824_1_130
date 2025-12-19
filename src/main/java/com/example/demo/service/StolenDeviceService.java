package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.StolenDevice;

public interface StolenDeviceService


{
    public StolenDevice reportStolen(StolenDevice report);
    public StolenDevice getBySerial(StolenDevice serialNumber);
    public StolenDevice getAllDevices();
    public StolenDevice updateDeviceStatus(StolenDevice id,active);
}