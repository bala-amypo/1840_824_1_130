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
