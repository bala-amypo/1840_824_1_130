package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;

import java.util.List;
import java.util.Optional;

public class DeviceOwnershipServiceImpl {
    private final DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repo) {
        this.repo = repo;
    }

    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord d) {
        if (repo.existsBySerialNumber(d.getSerialNumber())) {
            throw new IllegalArgumentException("Duplicate serial");
        }
        return repo.save(d);
    }

    public Optional<DeviceOwnershipRecord> getBySerial(String serial) {
        return repo.findBySerialNumber(serial);
    }

    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }

    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord d = repo.findById(id).orElseThrow();
        d.setActive(active);
        return repo.save(d);
    }
}
