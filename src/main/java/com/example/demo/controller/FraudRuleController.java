package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
@Tag(name = "Fraud Rules")
public class FraudRuleController {

private final FraudRuleService service;

public FraudRuleController(FraudRuleService service) {
this.service = service;
}

// Create rule
@PostMapping
public FraudRule create(@RequestBody FraudRule rule) {
return service.createRule(rule);
}

// Update rule
@PutMapping("/{id}")
public FraudRule update(@PathVariable Long id,
@RequestBody FraudRule rule) {
return service.updateRule(id, rule);
}

// List active rules
@GetMapping("/active")
public List<FraudRule> activeRules() {
return service.getActiveRules();
}

// Get rule by ID
@GetMapping("/{id}")
public FraudRule getById(@PathVariable Long id) {
return service.getAllRules()
.stream()
.filter(r -> r.getId().equals(id))
.findFirst()
.orElseThrow(() -> new java.util.NoSuchElementException("Fraud rule not found"));
}

// List all rules
@GetMapping
public List<FraudRule> allRules() {
return service.getAllRules();
}
}
