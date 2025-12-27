package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

import java.util.List;
import java.util.NoSuchElementException;

public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository ruleRepo;

    public FraudRuleServiceImpl(FraudRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {
        if (ruleRepo.findByRuleCode(rule.getRuleCode()) != null) {
            throw new IllegalArgumentException("Duplicate rule");
        }
        rule.setActive(true);
        return ruleRepo.save(rule);
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    // ✅ MUST return FraudRule (not Optional)
    @Override
    public FraudRule getRuleByCode(String ruleCode) {
        FraudRule rule = ruleRepo.findByRuleCode(ruleCode);
        if (rule == null) {
            throw new NoSuchElementException("Rule not found");
        }
        return rule;
    }

    @Override
    public List<FraudRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
