package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class FraudAlertController {

    private final FraudAlertService service;

    public FraudAlertController(FraudAlertService service) {
        this.service = service;
    }

    @GetMapping("/serial/{serial}")
    public List<FraudAlertRecord> bySerial(@PathVariable String serial) {
        return service.getAlertsBySerial(serial);
    }

    @GetMapping
    public List<FraudAlertRecord> all() {
        return service.getAllAlerts();
    }
}
