package ru.raiffeisen.ipr.service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends ServiceException {

public ClientNotFoundException(){
 super(HttpStatus.NOT_FOUND,"Клиента не существует!");
}
}
