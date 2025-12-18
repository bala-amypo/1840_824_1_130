package com.example.demo.model;
    public class DeviceOwnershipRecord{
        private Long id;
        private String serialNumber;
        private String ownerName;
        private String ownerEmail;
        private LocalDate purchaseDate;
        private LocalDate warrantyExpiration;
        private Boolean active;

        public Long getId(){
            return id;
        }
        public void setId(Long id){
            this.id = id;
        }
        public String getSerialNumber(){
            return serialNumber;
        }
        

    }
