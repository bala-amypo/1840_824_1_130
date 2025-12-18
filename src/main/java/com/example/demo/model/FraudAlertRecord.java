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
         public Long getClaimId(){
            return claimid;
        }
        public void setClaimId(Long claimId){
            this.claimId = claimId;
        }
        public String getSerialNumber(){
            return serialNumber;
        }
        public void setSerialNumber(String serialNumber){
            this.serialNumber = serialNumber;
        }
        public String getAlertType(){
            return alertType;
        }
        public void setAlertType(String alertType){
            this.alertType = alertType;
        }
        public String getSeverity(){
            return severity;
        }
        public void setSeverity(String severity){
            this.severity = severity;
        }
        public Boolean getActive(){
            return active;
        }
        public void setActive(Boolean active){
            this.active = active;
        }

    }
