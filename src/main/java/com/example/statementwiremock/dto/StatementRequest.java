package com.example.statementwiremock.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StatementRequest {
    private RequestHeader header;
    private Object meta;
    private RequestBody body;

    // Getters and setters
}
