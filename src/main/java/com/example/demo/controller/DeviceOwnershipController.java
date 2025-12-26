package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceOwnershipRecord register(@RequestBody DeviceOwnershipRecord d) {
        return service.registerDevice(d);
    }

    @PutMapping("/{id}/status")
    public DeviceOwnershipRecord updateStatus(@PathVariable Long id,
                                              @RequestParam boolean active) {
        return service.updateDeviceStatus(id, active);
    }

    @GetMapping("/serial/{serial}")
    public DeviceOwnershipRecord getBySerial(@PathVariable("serial") String serial) {
        return service.getBySerial(serial);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> listAll() {
        return service.getAllDevices();
    }
}
