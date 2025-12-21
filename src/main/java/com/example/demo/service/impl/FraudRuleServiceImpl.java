package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

private final FraudRuleRepository repository;

// REQUIRED constructor
public FraudRuleServiceImpl(FraudRuleRepository repository) {
this.repository = repository;
}

@Override
public FraudRule createRule(FraudRule rule) {
return repository.save(rule);
}

@Override
public FraudRule updateRule(Long id, FraudRule updatedRule) {
FraudRule existing = repository.findById(id)
.orElseThrow(() -> new NoSuchElementException("Fraud rule not found"));

existing.setRuleCode(updatedRule.getRuleCode());
existing.setDescription(updatedRule.getDescription());
existing.setRuleType(updatedRule.getRuleType());
existing.setActive(updatedRule.getActive());

return repository.save(existing);
}

@Override
public List<FraudRule> getActiveRules() {
return repository.findByActiveTrue();
}

@Override
public FraudRule getRuleByCode(String ruleCode) {
return repository.findByRuleCode(ruleCode)
.orElseThrow(() -> new NoSuchElementException("Fraud rule not found"));
}

@Override
public List<FraudRule> getAllRules() {
return repository.findAll();
}
}




