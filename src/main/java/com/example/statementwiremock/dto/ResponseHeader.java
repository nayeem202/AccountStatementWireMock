package com.example.statementwiremock.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ResponseHeader {
    private String requestId;
    private String requestReceivedTime;
    private String responseCode;
    private String responseMessage;
    private int responseProcessingTimeInMs;
    private String responseTime;
    private String responseVersion;
    private String traceId;
    private int hopCount;
    
    // Getters and setters
}