

package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/claims")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    @PostMapping
    public WarrantyClaimRecord submit(@RequestBody WarrantyClaimRecord claim) {
        return service.submitClaim(claim);
    }

    @PutMapping("/{id}/status")
    public WarrantyClaimRecord updateStatus(@PathVariable Long id,
                                            @RequestParam String status) {
        return service.updateClaimStatus(id, status);
    }

    @GetMapping("/serial/{serial}")
    public List<WarrantyClaimRecord> getBySerial(@PathVariable String serial) {
        return service.getClaimsBySerial(serial);
    }

    @GetMapping("/{id}")
    public WarrantyClaimRecord getById(@PathVariable Long id) {
        return service.getClaimById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @GetMapping
    public List<WarrantyClaimRecord> listAll() {
        return service.getAllClaims();
    }
}

