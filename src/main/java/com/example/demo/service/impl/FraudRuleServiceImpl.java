package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

private final FraudAlertRecordRepository repository;

// REQUIRED constructor
public FraudAlertServiceImpl(FraudAlertRecordRepository repository) {
this.repository = repository;
}

@Override
public FraudAlertRecord createAlert(FraudAlertRecord alert) {
return repository.save(alert);
}

@Override
public FraudAlertRecord resolveAlert(Long id) {
FraudAlertRecord alert = repository.findById(id)
.orElseThrow(() -> new NoSuchElementException("Fraud alert not found"));
alert.setResolved(true);
return repository.save(alert);
}

@Override
public List<FraudAlertRecord> getAlertsBySerial(String serialNumber) {
return repository.findAll()
.stream()
.filter(a -> a.getSerialNumber().equals(serialNumber))
.toList();
}

@Override
public List<FraudAlertRecord> getAlertsByClaim(Long claimId) {
return repository.findByClaimId(claimId);
}

@Override
public List<FraudAlertRecord> getAllAlerts() {
return repository.findAll();
}
}









package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

private final FraudRuleRepository repository;

// REQUIRED constructor
public FraudRuleServiceImpl(FraudRuleRepository repository) {
this.repository = repository;
}

@Override
public FraudRule createRule(FraudRule rule) {
return repository.save(rule);
}

@Override
public FraudRule updateRule(Long id, FraudRule updatedRule) {
FraudRule existing = repository.findById(id)
.orElseThrow(() -> new NoSuchElementException("Fraud rule not found"));

existing.setRuleCode(updatedRule.getRuleCode());
existing.setDescription(updatedRule.getDescription());
existing.setRuleType(updatedRule.getRuleType());
existing.setActive(updatedRule.getActive());

return repository.save(existing);
}

@Override
public List<FraudRule> getActiveRules() {
return repository.findByActiveTrue();
}

@Override
public FraudRule getRuleByCode(String ruleCode) {
return repository.findByRuleCode(ruleCode)
.orElseThrow(() -> new NoSuchElementException("Fraud rule not found"));
}

@Override
public List<FraudRule> getAllRules() {
return repository.findAll();
}
}








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








package com.example.demo.service.impl;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;
private final JwtTokenProvider jwtTokenProvider;

// REQUIRED constructor (order matters for tests)
public UserServiceImpl(UserRepository userRepository,
PasswordEncoder passwordEncoder,
JwtTokenProvider jwtTokenProvider) {
this.userRepository = userRepository;
this.passwordEncoder = passwordEncoder;
this.jwtTokenProvider = jwtTokenProvider;
}

@Override
public AuthResponse registerUser(RegisterRequest request) {

if (userRepository.existsByEmail(request.getEmail())) {
throw new IllegalArgumentException("Email already exists");
}

User user = new User();
user.setName(request.getName());
user.setEmail(request.getEmail());
user.setRoles(request.getRoles());
user.setPassword(passwordEncoder.encode(request.getPassword()));

User saved = userRepository.save(user);

String token = jwtTokenProvider.createToken(
saved.getId(),
saved.getEmail(),
saved.getRoles()
);

return new AuthResponse(token);
}

@Override
public AuthResponse loginUser(LoginRequest request) {

User user = userRepository.findByEmail(request.getEmail())
.orElseThrow(() -> new NoSuchElementException("User not found"));

if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
throw new IllegalArgumentException("Invalid credentials");
}

String token = jwtTokenProvider.createToken(
user.getId(),
user.getEmail(),
user.getRoles()
);

return new AuthResponse(token);
}
}







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
alert.setMessage("Claim submitted for stolen device");

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
public WarrantyClaimRecord getClaimById(Long id) {
return claimRepository.findById(id)
.orElseThrow(() -> new NoSuchElementException("Claim not found"));
}

@Override
public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
return claimRepository.findBySerialNumber(serialNumber);
}

@Override
public List<WarrantyClaimRecord> getAllClaims() {
return claimRepository.findAll();
}
}



