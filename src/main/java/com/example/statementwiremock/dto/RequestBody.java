package com.example.statementwiremock.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RequestBody {
    private String branchOid;
    private String bankAccountNo;
    private String fromDate;
    private String toDate;
    private int offset;
    private int limit;
    
    // Getters and setters
}