package ru.raiffeisen.ipr.service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ExistPlanException extends ServiceException {
    public ExistPlanException(String email){
        super(HttpStatus.BAD_REQUEST,"Клиент с email: " + email + " уже существует!");
    }
}