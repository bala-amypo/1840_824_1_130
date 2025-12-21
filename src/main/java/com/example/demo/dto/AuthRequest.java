
package com.example.demo.dto;

public class LoginRequest {

private String email;
private String password;

public String getEmail() { return email; }
public String getPassword() { return password; }

public void setEmail(String email) { this.email = email; }
public void setPassword(String password) { this.password = password; }
}





package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class JwtTokenProvider {

public String createToken(Long userId, String email, Set<String> roles) {
// SIMPLE stub token (enough to compile & run)
return "dummy-jwt-token-for-" + email;
}
}






<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-security</artifactId>
</dependency>





public interface DeviceOwnershipRecordRepository
extends JpaRepository<DeviceOwnershipRecord, Long> {

boolean existsBySerialNumber(String serialNumber);
}






public interface StolenDeviceReportRepository
extends JpaRepository<StolenDeviceReport, Long> {

boolean existsBySerialNumber(String serialNumber);
}






package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;

import java.util.List;

public interface FraudAlertService {

FraudAlertRecord createAlert(FraudAlertRecord alert);

FraudAlertRecord resolveAlert(Long id);

List<FraudAlertRecord> getAlertsBySerial(String serialNumber);

List<FraudAlertRecord> getAlertsByClaim(Long claimId);

List<FraudAlertRecord> getAllAlerts();
}





public interface WarrantyClaimService {

WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim);

WarrantyClaimRecord updateStatus(Long id, String status);

WarrantyClaimRecord getClaimById(Long id);

List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber);

List<WarrantyClaimRecord> getAllClaims();
}
