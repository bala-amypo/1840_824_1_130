package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entityclass.FraudAlertRecord;

public interface FraudAlertRecord extends JpaRepository<FraudAlertRecord,Long>{
    
}