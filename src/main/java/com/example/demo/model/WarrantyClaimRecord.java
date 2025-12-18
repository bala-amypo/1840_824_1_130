package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.time.LocalDate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
  @Entity
  public class WarrantyClaimRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    public String getClaimantEmail(){
        return claimantEmail;
    }
    public void setclaimantEmail(String claimantEmail){
        this.claimantEmail = claimantEmail;
    }
    public String getClaimReason(){
        return claimReason;
    }
    public void setClaimantReason(String claimReason){
        this.claimReason = claimReason;
    }
    public LocalDateTime getsubmittedAt(){
        return submittedAt;
    }
    public void  setSubmittedAt(LocalDateTime submittedAt){
        this.submittedAt = submittedAt;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public WarrantyClaimRecord(Long id,String serialNumber,String claimantName,String claimantEmail,String claimReason,LocalDateTime submittedAt,String status){
        this.id = id;
        this.serialNumber = serialNumber;
        this.claimantName = claimantName;
        this.claimantEmail = claimantEmail;
        this.claimReason = claimReason;
        this.submittedAt = submittedAt;
        this.status = status;
        
    }
    public WarrantyClaimRecord(){
        
    }
  
}
