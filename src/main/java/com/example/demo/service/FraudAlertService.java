package com.example.demo.service;



import com.example.demo.model.FraudAlertRecord;

public interface FraudAlertService


{
   }   public FraudAlert createAlert(FraudAlert alert);
    public FraudAlert resolveAlert(FraudAlert id);
    public FraudAlert getAlertsBySerial(FraudAlert serialNumber);
    public FraudAlert getAlertsByClaim(FraudAlert claimId);
    public FraudAlert getAllAlerts();
