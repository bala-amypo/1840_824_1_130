package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repo;

    public FraudRuleServiceImpl(FraudRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {
        return repo.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule updated) {
        var existing = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
        existing.setRuleCode(updated.getRuleCode());
        existing.setDescription(updated.getDescription());
        existing.setRuleType(updated.getRuleType());
        existing.setActive(updated.getActive());
        return repo.save(existing);
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public FraudRule getRuleByCode(String ruleCode) {
        return repo.findByRuleCode(ruleCode);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repo.findAll();
    }
}
