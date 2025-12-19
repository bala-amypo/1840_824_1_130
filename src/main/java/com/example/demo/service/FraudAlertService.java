package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.FraudRule;

public interface FraudRuleService


{
    public FraudRule createRule(FraudRule rule);
    public FraudRule updateRule(FraudRule id,updatedRule);
    public FraudRule getActiveRules();
    public FraudRule getRuleByCode(FraudRule ruleCode);
    public FraudRule getAllRules();
}