package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.DeviceOwnershipRecord;

import java.util.Optional;

public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnershipRecord, Long> {

boolean existsBySerialNumber(String serialNumber);
}