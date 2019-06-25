package ru.raiffeisen.ipr.service.exeption;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException{

    private HttpStatus httpStatus;

    public ServiceException(HttpStatus httpStatus, String massage) {
        super(massage);
        this.httpStatus = httpStatus;
    }
    public  HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
