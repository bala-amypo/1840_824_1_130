package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.FraudAlertService;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

private final WarrantyClaimRecordRepository claimRepository;
private final StolenDeviceReportRepository stolenRepository;
private final FraudAlertService fraudAlertService;

// REQUIRED constructor
public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository claimRepository,
StolenDeviceReportRepository stolenRepository,
FraudAlertService fraudAlertService) {
this.claimRepository = claimRepository;
this.stolenRepository = stolenRepository;
this.fraudAlertService = fraudAlertService;
}

@Override
public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

// Check if device is reported stolen
if (stolenRepository.existsBySerialNumber(claim.getSerialNumber())) {
claim.setStatus("FLAGGED");

FraudAlertRecord alert = new FraudAlertRecord();
alert.setSerialNumber(claim.getSerialNumber());
alert.setAlertType("STOLEN_DEVICE");
alert.setSeverity("HIGH");
alert.setDescription("Device is stolen");


fraudAlertService.createAlert(alert);
}

return claimRepository.save(claim);
}

@Override
public WarrantyClaimRecord updateStatus(Long id, String status) {
WarrantyClaimRecord claim = claimRepository.findById(id)
.orElseThrow(() -> new NoSuchElementException("Claim not found"));
claim.setStatus(status);
return claimRepository.save(claim);
}

@Override
public WarrantyClaimRecord claim = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Claim not found"));


@Override
public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
return claimRepository.findBySerialNumber(serialNumber);
}

@Override
public List<WarrantyClaimRecord> getAllClaims() {
return claimRepository.findAll();
}
}