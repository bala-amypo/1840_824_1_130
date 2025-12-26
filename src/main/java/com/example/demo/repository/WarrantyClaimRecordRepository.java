package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimRecordRepository extends JpaRepository<WarrantyClaimRecord, Long> {
    boolean existsBySerialNumberAndClaimReason(String serialNumber, String claimReason);
    List<WarrantyClaimRecord> findBySerialNumber(String serialNumber);
}
