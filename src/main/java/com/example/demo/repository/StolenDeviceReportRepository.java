package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.StolenDeviceReport;
import java.util.Optional;
import java.util.List;

public interface StolenDeviceReportRepository extends JpaRepository<StolenDeviceReport, Long> {

boolean existsBySerialNumber(String serialNumber);
}