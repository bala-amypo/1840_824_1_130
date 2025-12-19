package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.WarrantyClaimRecord;
import java.util.Optional;

public interface WarrantyClaimRecordRepository extends JpaRepository<WarrantyClaimRecord,Long>{

    boolean existBySerialNumber(String serialNumber);
    Optional<WarrantyClaimRecord>findBySerialNumber(String serialNumber);
    
}