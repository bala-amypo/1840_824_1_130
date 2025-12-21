package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

private final StolenDeviceReportRepository reportRepository;
private final DeviceOwnershipRecordRepository deviceRepository;

// REQUIRED constructor (order matters for tests)
public StolenDeviceServiceImpl(StolenDeviceReportRepository reportRepository,
DeviceOwnershipRecordRepository deviceRepository) {
this.reportRepository = reportRepository;
this.deviceRepository = deviceRepository;
}

@Override
public StolenDeviceReport reportStolen(StolenDeviceReport report) {
if (!deviceRepository.existsBySerialNumber(report.getSerialNumber())) {
throw new NoSuchElementException("Device not found");
}
return reportRepository.save(report);
}

@Override
public List<StolenDeviceReport> getReportsBySerial(String serialNumber) {
return reportRepository.findAll()
.stream()
.filter(r -> r.getSerialNumber().equals(serialNumber))
.toList();
}

@Override
public StolenDeviceReport getReportById(Long id) {
return reportRepository.findById(id)
.orElseThrow(() -> new NoSuchElementException("Stolen report not found"));
}

@Override
public List<StolenDeviceReport> getAllReports() {
return reportRepository.findAll();
}
}
