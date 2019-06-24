package ru.raiffeisen.ipr.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.raiffeisen.ipr.service.exeption.ServiceException;

@RestControllerAdvice
public class ExceptionAdvice {

    private Logger logger = LoggerFactory.getLogger("ExceptionAdvice");

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<?> clientExceptionHandler(ServiceException e) {
        logger.error(e.getMessage());
        return ResponseEntity.status(e.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON_UTF8).body(e.getMessage());
    }
}
