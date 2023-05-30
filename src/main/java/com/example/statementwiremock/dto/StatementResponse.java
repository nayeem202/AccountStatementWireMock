package com.example.statementwiremock.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StatementResponse {
    private ResponseHeader header;
    private Object meta;
    private ResponseBody body;
    
    // Getters and setters
}