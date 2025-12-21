package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
@Tag(name = "Fraud Alerts")
public class FraudAlertController {

private final FraudAlertService service;

public FraudAlertController(FraudAlertService service) {
this.service = service;
}

// Create fraud alert
@PostMapping
public FraudAlertRecord create(@RequestBody FraudAlertRecord alert) {
return service.createAlert(alert);
}

// Resolve alert
@PutMapping("/{id}/resolve")
public FraudAlertRecord resolve(@PathVariable Long id) {
return service.resolveAlert(id);
}

// Alerts by serial number
@GetMapping("/serial/{serialNumber}")
public List<FraudAlertRecord> bySerial(@PathVariable String serialNumber) {
return service.getAlertsBySerial(serialNumber);
}

// Alerts by claim
@GetMapping("/claim/{claimId}")
public List<FraudAlertRecord> byClaim(@PathVariable Long claimId) {
return service.getAlertsByClaim(claimId);
}

// List all alerts
@GetMapping
public List<FraudAlertRecord> all() {
return service.getAllAlerts();
}
}
