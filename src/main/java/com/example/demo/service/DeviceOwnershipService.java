package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.DeviceOwnershipRecord;
import java.util.List;

public interface DeviceOwnershipService{
     DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device);
     DeviceOwnershipRecord getBySerial(String serialNumber);
     List<DeviceOwnershipRecord> getAllDevices();
     DeviceOwnershipRecord updateDeviceStatus(Long id,boolean active);
}