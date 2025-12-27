package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository deviceRepo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord record) {
        if (deviceRepo.existsBySerialNumber(record.getSerialNumber())) {
            throw new IllegalArgumentException("Duplicate serial number");
        }
        record.setActive(true);
        return deviceRepo.save(record);
    }

    @Override
    public Optional<DeviceOwnershipRecord> getBySerial(String serialNumber) {
        return deviceRepo.findBySerialNumber(serialNumber);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return deviceRepo.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, Boolean active) {
        DeviceOwnershipRecord d = deviceRepo.findById(id)
                .orElseThrow(NoSuchElementException::new);
        d.setActive(active);
        return deviceRepo.save(d);
    }
}
