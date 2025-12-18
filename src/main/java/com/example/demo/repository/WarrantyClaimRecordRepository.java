package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entityclass.WarrantyClaimRecord;

public interface WarrantyClaimRecordRepository extends JpaRepository<WarrantyClaimRecord,Long>{
    
}