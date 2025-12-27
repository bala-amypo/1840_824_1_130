package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService deviceService;

    public DeviceOwnershipController(DeviceOwnershipService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public DeviceOwnershipRecord register(@RequestBody DeviceOwnershipRecord record) {
        return deviceService.registerDevice(record);
    }

    @GetMapping("/{serial}")
    public DeviceOwnershipRecord getBySerial(@PathVariable String serial) {
        return deviceService.getBySerial(serial)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAll() {
        return deviceService.getAllDevices();
    }
}
