package com.example.demo.model;
    public class StolenDeviceReport{
        private Long id;
        private String serialNumber;
        private String reportedBy;
        private LocalDateTime reportDate;
        private String details;

        public Long getId(){
            return id;
        }
        public void setId(Long id){
            this.id = id;
        }
        public String getSerialNumber(){
            return serialNumber;
        }
        public void setSerialNumber(String serialNumber){
            this.serialNumber = serialNumber;
        }
        public String setReportedBy(){
            return reportedBy
        }
        public void (String ownerName){
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
