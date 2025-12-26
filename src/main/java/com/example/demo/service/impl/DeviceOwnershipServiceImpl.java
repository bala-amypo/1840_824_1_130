package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord record) {
        if (repo.existsBySerialNumber(record.getSerialNumber())) {
            throw new IllegalArgumentException("Device already exists");
        }
        return repo.save(record);
    }

    @Override
    public DeviceOwnershipRecord getBySerial(String serial) {
        return repo.findBySerialNumber(serial);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord d = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
        d.setActive(active);
        return repo.save(d);
    }
}
