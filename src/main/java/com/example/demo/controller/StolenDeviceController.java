package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
@Tag(name = "Stolen Devices")
public class StolenDeviceController {

private final StolenDeviceService service;

public StolenDeviceController(StolenDeviceService service) {
this.service = service;
}

// Report stolen device
@PostMapping
public StolenDeviceReport report(@RequestBody StolenDeviceReport report) {
return service.reportStolen(report);
}

// Get reports by serial
@GetMapping("/serial/{serialNumber}")
public List<StolenDeviceReport> bySerial(@PathVariable String serialNumber) {
return service.getReportsBySerial(serialNumber);
}

// Get report by ID
@GetMapping("/{id}")
public StolenDeviceReport byId(@PathVariable Long id) {
return service.getReportById(id);
}

// List all reports
@GetMapping
public List<StolenDeviceReport> all() {
return service.getAllReports();
}
}






package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@Tag(name = "Warranty Claims")
public class WarrantyClaimController {

private final WarrantyClaimService service;

public WarrantyClaimController(WarrantyClaimService service) {
this.service = service;
}

// Submit claim
@PostMapping
public WarrantyClaimRecord submit(@RequestBody WarrantyClaimRecord claim) {
return service.submitClaim(claim);
}

// Update claim status
@PutMapping("/{id}/status")
public WarrantyClaimRecord updateStatus(@PathVariable Long id,
@RequestParam String status) {
return service.updateStatus(id, status);
}

// Get claim by ID
@GetMapping("/{id}")
public WarrantyClaimRecord getById(@PathVariable Long id) {
return service.getClaimById(id);
}

// Get claims by serial number
@GetMapping("/serial/{serialNumber}")
public List<WarrantyClaimRecord> bySerial(@PathVariable String serialNumber) {
return service.getClaimsBySerial(serialNumber);
}

// Get all claims
@GetMapping
public List<WarrantyClaimRecord> all() {
return service.getAllClaims();
}
}
