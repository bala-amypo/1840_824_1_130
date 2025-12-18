package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.WarrantyClaimRecord;

public interface WarrantyClaimRecordRepository extends JpaRepository<WarrantyClaimRecord,Long>{
    
}