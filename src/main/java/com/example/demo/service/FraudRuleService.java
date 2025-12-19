package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.Fraud;

public interface DeviceOwnershipService


{
    public DeviceOwnership registerDevice(DeviceOwnership device);
    public DeviceOwnership getBySerial(DeviceOwnership serialNumber);
    public DeviceOwnership getAllDevices();
    public DeviceOwnership updateDeviceStatus(DeviceOwnership id,active);
}