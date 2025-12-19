package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.StolenDeviceReport;
import java.util.Optional;

public interface StolenDeviceReportRepository extends JpaRepository<StolenDeviceReport,Long>{

    boolean existBySerialNumber(String serialNumber);
    Optional<StolenDeviceReport>findBySerialNumber(String serialNumber);
    
}