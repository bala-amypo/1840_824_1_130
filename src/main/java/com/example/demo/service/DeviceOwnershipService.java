package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.DeviceOwnership;

public interface DeviceOwnershipService


{
    public User registerDevice(User device);
    public User getBySerial(User serialNumber);
    public User getAllDevices();
    public User updateDeviceStatus(User id,active);
}