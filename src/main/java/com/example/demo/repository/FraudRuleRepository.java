package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entityclass.FraudRule;

public interface FraudRuleRepository extends JpaRepository<FraudRule,Long>{
    
}