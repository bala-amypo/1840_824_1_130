package com.example.demo.model;
    public class FraudAlertRecord{
        private Long id;
        private Long claimId;
        private String serialNumber;
        private String alertType;
        private String severity;
        private String message;
        private LocalDateTime alertDate;
        private Boolean resolved;

        public Long getId(){
            return id;
        }
        public void setId(Long id){
            this.id = id;
        }
         public Long get(){
            return id;
        }
        public void setId(Long id){
            this.id = id;
        }
        public String getRuleCode(){
            return ruleCode;
        }
        public void setRuleCode(String ruleCode){
            this.ruleCode = ruleCode;
        }
        public String getDescription(){
            return description;
        }
        public void setDescription(String description){
            this.description = description;
        }
        public String getRuleType(){
            return ruleType;
        }
        public void setRuleType(String ruleType){
            this.ruleType = ruleType;
        }
        public Boolean getActive(){
            return active;
        }
        public void setActive(Boolean active){
            this.active = active;
        }

    }
