package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entityclass.DeviceOwnershipRecord;

public interface DeviceOwnershipRecord extends JpaRepository<DeviceOwnershipRecord,Long>{
    
}