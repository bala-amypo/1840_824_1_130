package com.example.demo.model;
    public class FraudRule{
        private Long id;
        private String ruleCode;
        private String description;
        private String ruleType;
        private Boolean active;

        public Long getId(){
            return id;
        }
        public void setId(Long id){
            this.id = id;
        }
        public String getRuleCode(){
            return ruleCode;
        }
        public void setRuleCode(String ruleCode){
            this.ruleCode = serialNumber;
        }
        public String getOwnerName(){
            return ownerName;
        }
        public void setOwnerName(String ownerName){
            this.ownerName = ownerName;
        }
        public String getOwnerEmail(){
            return ownerEmail;
        }
        public void setOwnerEmail(String ownerEmail){
            this.ownerEmail = ownerEmail;
        }
        public LocalDate getPurchaseDate(){
            return purchaseDate;
        }
        public void setPurchaseDate(LocalDate purchaseDate){
            this.purchaseDate = purchaseDate;
        }
        public LocalDate getwarrantyExpiration(){
            return warrantyExpiration;
        }
        public void setWarrantyExpiration(LocalDate warrantyExpiration){
            this.warrantyExpiration = warrantyExpiration;
        }
        public Boolean getActive(){
            return active;
        }
        public void setActive(Boolean active){
            this.active = active;
        }

    }
