package com.example.statementwiremock.controller;

import com.example.statementwiremock.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/mock")
public class MockApiController {

    @PostMapping(value = "/statement", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<StatementResponse> getStatement(@org.springframework.web.bind.annotation.RequestHeader("Authorization") String authorizationHeader, @RequestBody StatementRequest request) {
        String expectedBearerToken = "af821abf-f6ea-4ef4-996b-3cd49ceebbac";
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ") || !authorizationHeader.substring(7).equals(expectedBearerToken)) {
            throw new RuntimeException("Invalid or missing authorization token");
        }

        // Perform mock processing
        StatementResponse response = new StatementResponse();
        response.setHeader(createResponseHeader(request.getHeader()));
        response.setMeta(request.getMeta());
        response.setBody(createResponseBody(authorizationHeader));

        return Mono.just(response);
    }

    private ResponseHeader createResponseHeader(RequestHeader requestHeader) {
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setRequestId(requestHeader.getRequestId());
        responseHeader.setRequestReceivedTime(requestHeader.getRequestTime());
        responseHeader.setResponseCode("200");
        responseHeader.setResponseMessage("CBS Response found");
        responseHeader.setResponseProcessingTimeInMs(273);
        responseHeader.setResponseTime("2017-01-17T07:02:08.638Z");
        responseHeader.setResponseVersion("1.0");
        responseHeader.setTraceId(requestHeader.getTraceId());
        responseHeader.setHopCount(0);

        return responseHeader;
    }

    private ResponseBody createResponseBody(String authorizationHeader) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setBalanceAtStart(100);
        responseBody.setTotalRecord(6909);
        responseBody.setCount(100);
        responseBody.setTransactions(new ArrayList<>()); // Initialize the transactions list

        Transaction transaction1 = new Transaction();
        transaction1.setSl(1);
        transaction1.setTransactionDate("2017-01-17");
        transaction1.setDebitAmount(-200);
        transaction1.setCreditAmount(0);
        transaction1.setTransactionCode("946");
        transaction1.setReferenceNo("FT16111YCMZ1");
        transaction1.setChequeNo("");
        transaction1.setNarrative("D CHG-DOER Card");

        Transaction transaction2 = new Transaction();
        transaction2.setSl(2);
        transaction2.setTransactionDate("2017-01-18");
        transaction2.setDebitAmount(0);
        transaction2.setCreditAmount(500);
        transaction2.setTransactionCode("945");
        transaction2.setReferenceNo("FT16111YCMZ2");
        transaction2.setChequeNo("");
        transaction2.setNarrative("D CHG-DOER Card");

        responseBody.getTransactions().add(transaction1);
        responseBody.getTransactions().add(transaction2);

        return responseBody;
    }


}
