package com.uok.sams.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeSramp;

    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timeSramp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeSramp = timeSramp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeSramp() {
        return timeSramp;
    }
}
