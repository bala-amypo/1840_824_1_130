package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String customerName;
    private String issueDescription;
    private String status;

    private LocalDateTime createdAt;
    private String resolution;
}
