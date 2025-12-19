package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.FraudAlertRecord;

public interface FraudAlertRecordRepository extends JpaRepository<FraudAlertRecord,Long>{
    
}