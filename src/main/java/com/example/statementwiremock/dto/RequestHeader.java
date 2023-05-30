package com.example.statementwiremock.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RequestHeader {
    private String requestClient;
    private String requestId;
    private int requestRetryCount;
    private String requestSource;
    private String requestSourceService;
    private String requestTime;
    private int requestTimeoutInSeconds;
    private String requestType;
    private String requestVersion;
    private String traceId;
    
    // Getters and setters
}