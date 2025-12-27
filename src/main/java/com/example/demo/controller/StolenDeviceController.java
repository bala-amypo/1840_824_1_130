package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stolen")
public class StolenDeviceController {

    private final StolenDeviceService service;

    public StolenDeviceController(StolenDeviceService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public StolenDeviceReport getById(@PathVariable Long id) {
        return service.getReportById(id);
    }
}
