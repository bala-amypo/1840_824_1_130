package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.FraudRule;
import java.util.Optional;

public interface FraudRuleRepository extends JpaRepository<FraudRule,Long>{

    List<FraudRule>findByActiveTrue();
    Optional<FraudRule>findBySerialNumber(String serialNumber);

}