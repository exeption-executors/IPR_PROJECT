package ru.raiffeisen.ipr.service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PlanNotFoundException extends ServiceException {

    public PlanNotFoundException(Long id){
        super(HttpStatus.NOT_FOUND,"Плана с id: " + id + " не существует!");
    }
}
