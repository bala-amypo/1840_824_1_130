

package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stolen")
public class StolenDeviceController {

    private final StolenDeviceService service;

    public StolenDeviceController(StolenDeviceService service) {
        this.service = service;
    }

    @PostMapping
    public StolenDeviceReport report(@RequestBody StolenDeviceReport report) {
        return service.reportStolen(report);
    }

    @GetMapping("/serial/{serial}")
    public List<StolenDeviceReport> bySerial(@PathVariable String serial) {
        return service.getReportsBySerial(serial);
    }

    @GetMapping
    public List<StolenDeviceReport> all() {
        return service.getAllReports();
    }
}
