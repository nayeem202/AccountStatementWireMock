package com.example.statementwiremock.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
public class ResponseBody {
    private int balanceAtStart;
    private int totalRecord;
    private int count;
    private List<Transaction> transactions;
    
    // Getters and setters
}