// package com.example.demo.controller;

// import com.example.demo.model.FraudAlertRecord;
// import com.example.demo.service.FraudAlertService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/alerts")
// public class FraudAlertController {

//     private final FraudAlertService service;

//     public FraudAlertController(FraudAlertService service) {
//         this.service = service;
//     }

//     @GetMapping("/serial/{serial}")
//     public List<FraudAlertRecord> bySerial(@PathVariable String serial) {
//         return service.getAlertsBySerial(serial);
//     }

//     @GetMapping
//     public List<FraudAlertRecord> all() {
//         return service.getAllAlerts();
//     }
// }

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

    @PostMapping
    public FraudAlertRecord create(@RequestBody FraudAlertRecord alert) {
        return service.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public FraudAlertRecord resolve(@PathVariable Long id) {
        return service.resolveAlert(id);
    }

    @GetMapping("/claim/{claimId}")
    public List<FraudAlertRecord> byClaim(@PathVariable Long claimId) {
        return service.getAlertsByClaim(claimId);
    }
}
