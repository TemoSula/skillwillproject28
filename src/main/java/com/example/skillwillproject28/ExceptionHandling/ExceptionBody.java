package com.example.skillwillproject28.ExceptionHandling;

import org.springframework.http.HttpStatusCode;

public class ExceptionBody {

    private String message;
    private HttpStatusCode httpStatus;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatusCode getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatusCode httpStatus) {
        this.httpStatus = httpStatus;
    }
}
