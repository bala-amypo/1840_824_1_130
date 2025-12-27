package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private Map<Long, FraudRule> rules = new HashMap<>();

    @Override
    public FraudRule updateRule(Long id, FraudRule updated) {
        FraudRule existing = rules.get(id);
        if (existing != null) {
            existing.setRuleCode(updated.getRuleCode());
            existing.setDescription(updated.getDescription());
            existing.setRuleType(updated.getRuleType());
            existing.setActive(updated.isActive()); // Fixed: isActive() instead of getActive()
        }
        return existing;
    }
}
