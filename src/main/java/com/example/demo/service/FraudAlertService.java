package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.FraudAlert;

public interface FraudAlertService


{
    public FraudAlert createAlert(FraudAlert alert);
    public FraudAlert resolveAlert(FraudAlert id);
    public FraudAlert getAlertsBySerial(FraudAlert serialNumber);
    public FraudAlert getAlertsByClaim(FraudAlert claimId);
    public FraudAlert getAllAlerts();
}