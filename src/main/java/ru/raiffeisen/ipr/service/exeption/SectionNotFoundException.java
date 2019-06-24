package ru.raiffeisen.ipr.service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.raiffeisen.ipr.entity.Section;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SectionNotFoundException extends ServiceException {

    public SectionNotFoundException(Long id){
        super(HttpStatus.NOT_FOUND,"Секции с id: " + id + " не существует!");
    }
}