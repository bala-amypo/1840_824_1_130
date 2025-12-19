package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.FraudAlert;

public interface FraudAlertService


{
    public FraudAlert createAlert(FraudAlert alert);
    public FraudAlert resolveAlert(FraudAlert id);
    public FraudAlert getAlertsBySerial(serialNumber);
    public FraudAlert getAlertsBySerial(FraudAlert ruleCode);
    public FraudAlert getAllRules();
}