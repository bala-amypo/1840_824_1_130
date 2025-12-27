package com.example.demo.repository;

import com.example.demo.model.DeviceOwnershipRecord;

import java.util.*;

public class DeviceOwnershipRecordRepository {
    private final Map<Long, DeviceOwnershipRecord> storage = new HashMap<>();
    private Long idCounter = 1L;

    public DeviceOwnershipRecord save(DeviceOwnershipRecord record) {
        if (record.getId() == null) record.setId(idCounter++);
        storage.put(record.getId(), record);
        return record;
    }

    public Optional<DeviceOwnershipRecord> findBySerialNumber(String serial) {
        return storage.values().stream().filter(d -> d.getSerialNumber().equals(serial)).findFirst();
    }

    public Optional<DeviceOwnershipRecord> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public boolean existsBySerialNumber(String serial) {
        return storage.values().stream().anyMatch(d -> d.getSerialNumber().equals(serial));
    }

    public List<DeviceOwnershipRecord> findAll() {
        return new ArrayList<>(storage.values());
    }
}
