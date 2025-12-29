
package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @PostMapping
    public FraudRule create(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/active")
    public List<FraudRule> activeRules() {
        return service.getActiveRules();
    }

    @GetMapping("/{code}")
    public FraudRule getByCode(@PathVariable String code) {
        return service.getRuleByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("Rule not found"));
    }
}
