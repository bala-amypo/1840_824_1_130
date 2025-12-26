package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ruleId;
    private String serialNumber;
    private String alertType;
    private String description;
    private String severity;

    private LocalDateTime createdAt;
    private Boolean resolved;
}
