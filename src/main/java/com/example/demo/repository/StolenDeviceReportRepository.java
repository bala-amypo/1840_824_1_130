package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.StolenDeviceReport;
import java.util.Optional;
import java.util.List;


public interface StolenDeviceReportRepository {
    Optional<StolenDeviceReport> findBySerialNumber(String serialNumber);
}
