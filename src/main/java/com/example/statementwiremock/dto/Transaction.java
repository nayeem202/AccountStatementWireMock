package com.example.statementwiremock.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Transaction {
    private int sl;
    private String transactionDate;
    private int debitAmount;
    private int creditAmount;
    private String transactionCode;
    private String referenceNo;
    private String chequeNo;
    private String narrative;
    
    // Getters and setters
}