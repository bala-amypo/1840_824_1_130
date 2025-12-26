package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimRecordRepository {
    boolean existsBySerialNumberAndClaimReason(String serialNumber, String claimReason);
}