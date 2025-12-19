package com.example.demo.service;



import com.example.demo.model.FraudAlertRecord;
import java.util.List;

public interface FraudAlertService{
    FraudAlertRecord createAlert(FraudAlertRecord alert);
    FraudAlertRecord resolveAlert(Long id);
    FraudAlertRecord getAlertsBySerial(String serialNumber);
    FraudAlertRecord getAlertsByClaim(Long claimId);
    FraudAlertRecord getAllAlerts();
   } 
   
   
