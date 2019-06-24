package ru.raiffeisen.ipr.service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PointNotFoundException extends ServiceException {

    public PointNotFoundException(Long id){
        super(HttpStatus.NOT_FOUND,"Point с id: " + id + " не существует!");
    }
}