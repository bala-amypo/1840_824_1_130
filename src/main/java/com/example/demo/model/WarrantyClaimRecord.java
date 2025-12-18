package com.example.demo.model;
  public class WarrantyClaimRecord{
    private Long id;
    private String serialNumber;
    private String claimantName;
    private String claimantEmail;
    private String claimReason;
    private LocalDateTime submittedAt;
    private String status;

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
    public String getClaimantName(){
        return claimantName;
    }
    public void setClaimantName(String claimantName){
        this.claimantName = claimantName;
    }
    public String getClaimant
  }
