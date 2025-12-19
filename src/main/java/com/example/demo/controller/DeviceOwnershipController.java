package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "Device Ownership")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService service) {
        this.service = service;
    }

    // Register device
    @PostMapping
    public DeviceOwnershipRecord register(@RequestBody DeviceOwnershipRecord device) {
        return service.registerDevice(device);
    }

    // Activate / Deactivate device
    @PutMapping("/{id}/status")
    public DeviceOwnershipRecord updateStatus(@PathVariable Long id,
                                              @RequestParam boolean active) {
        return service.updateDeviceStatus(id, active);
    }

    // Get device by serial number
    @GetMapping("/serial/{serialNumber}")
    public DeviceOwnershipRecord getBySerial(@PathVariable String serialNumber) {
        return service.getBySerial(serialNumber);
    }

    // List all devices
    @GetMapping
    public List<DeviceOwnershipRecord> getAll() {
        return service.getAllDevices();
    }
}