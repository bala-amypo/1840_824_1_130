package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.DeviceOwnership;

public interface DeviceOwnershipService


{
     DeviceOwnership registerDevice(DeviceOwnership device);
     DeviceOwnership getBySerial(DeviceOwnership serialNumber);
     DeviceOwnership getAllDevices();
     DeviceOwnership updateDeviceStatus(DeviceOwnership id,active);
}