package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.StolenDeviceReport;

public interface StolenDeviceReportRepository extends JpaRepository<StolenDeviceReport,Long>{
    
}