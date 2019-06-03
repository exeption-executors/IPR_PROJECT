package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.entity.Client;

import java.util.List;

public interface ClientService {
    void insertClient(String name, String surname, String email, boolean fired);
    void deleteClientByEmail (String email);
    void deleteClientById(Long id);
    Client findByEmail(String email);
    Client findByName(String name);
    List<Client> getAll();
    void updateClient(String name, String surname, String email, boolean fired, Long id);
}
