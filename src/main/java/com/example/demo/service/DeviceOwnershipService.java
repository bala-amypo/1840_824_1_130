package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.DeviceOwnershipRecord;

public interface DeviceOwnershipService{
     DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device);
     DeviceOwnershipRecord getBySerial(String serialNumber);
     List<DeviceOwnershipRecord> getAllDevices();
     DeviceOwnershipRecord updateDeviceStatus(Long id,boolean active);
}