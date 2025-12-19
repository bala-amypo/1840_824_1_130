package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.FraudAlertRecord;
import java.util.Optional;

public interface FraudAlertRecordRepository extends JpaRepository<FraudAlertRecord,Long>{

    boolean existBySerialNumber(String serialNumber);
    Optional<FraudAlertRecord>findBySerialNumber(String serialNumber);

}