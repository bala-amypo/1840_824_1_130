package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.*;
import com.example.demo.service.WarrantyClaimService;

import java.util.List;
import java.util.NoSuchElementException;

public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;
    private final StolenDeviceReportRepository stolenRepo;
    private final FraudAlertRecordRepository alertRepo;
    private final FraudRuleRepository ruleRepo;

    public WarrantyClaimServiceImpl(
            WarrantyClaimRecordRepository claimRepo,
            DeviceOwnershipRecordRepository deviceRepo,
            StolenDeviceReportRepository stolenRepo,
            FraudAlertRecordRepository alertRepo,
            FraudRuleRepository ruleRepo
    ) {
        this.claimRepo = claimRepo;
        this.deviceRepo = deviceRepo;
        this.stolenRepo = stolenRepo;
        this.alertRepo = alertRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

        // device exists?
        if (!deviceRepo.existsBySerialNumber(claim.getSerialNumber())) {
            throw new NoSuchElementException("Device not found");
        }

        // stolen?
        if (stolenRepo.existsBySerialNumber(claim.getSerialNumber())) {
            WarrantyClaimRecord saved = claimRepo.save(claim);
            alertRepo.save(new com.example.demo.model.FraudAlertRecord(
                    saved.getId(),
                    claim.getSerialNumber(),
                    "STOLEN_DEVICE",
                    "HIGH",
                    "Device is reported stolen"
            ));
            return saved;
        }

        // expired?
        var device = deviceRepo.findBySerialNumber(claim.getSerialNumber());
        if (device.getWarrantyExpiration() != null &&
                device.getWarrantyExpiration().isBefore(java.time.LocalDate.now())) {
            var saved = claimRepo.save(claim);
            alertRepo.save(new com.example.demo.model.FraudAlertRecord(
                    saved.getId(),
                    claim.getSerialNumber(),
                    "WARRANTY_EXPIRED",
                    "MEDIUM",
                    "Warranty has expired"
            ));
            return saved;
        }

        // duplicate?
        if (claimRepo.existsBySerialNumberAndClaimReason(
                claim.getSerialNumber(),
                claim.getClaimReason()
        )) {
            var saved = claimRepo.save(claim);
            alertRepo.save(new com.example.demo.model.FraudAlertRecord(
                    saved.getId(),
                    claim.getSerialNumber(),
                    "DUPLICATE_CLAIM",
                    "LOW",
                    "Duplicate reason for same serial"
            ));
            return saved;
        }

        return claimRepo.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        var c = claimRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Claim not found"));
        c.setStatus(status);
        return claimRepo.save(c);
    }

    @Override
    public WarrantyClaimRecord getClaimById(Long id) {
        return claimRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Claim not found"));
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepo.findBySerialNumber(serialNumber);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepo.findAll();
    }
}
