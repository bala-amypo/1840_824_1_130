package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @PostMapping
    public FraudRule create(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public FraudRule update(@PathVariable Long id, @RequestBody FraudRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<FraudRule> activeRules() {
        return service.getActiveRules();
    }

    @GetMapping("/{id}")
    public FraudRule getById(@PathVariable Long id) {
        return service.getRuleByCode(service.getRuleByCode(ruleCode).getRuleCode());
    }

    @GetMapping
    public List<FraudRule> listAll() {
        return service.getAllRules();
    }
}
