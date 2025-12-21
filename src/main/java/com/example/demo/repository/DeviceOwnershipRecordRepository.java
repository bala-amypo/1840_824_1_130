package com.example.demo.repository;

import com.example.demo.model.DeviceOwnershipRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnershipRecord, Long> {

boolean existsBySerialNumber(String serialNumber);

Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);
}




package com.example.demo.service;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;

public interface UserService {

AuthResponse registerUser(RegisterRequest request);

AuthResponse loginUser(LoginRequest request);
}



