package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client saveClient(Client client);
    void deleteClientByEmail (String email);
    void deleteClientById(Long id);
    Optional<Client> findById(Long id);
    Client findByEmail(String email);
    Client findByName(String name);
    List<Client> getAll();
    void updateClient(String name, String surname, String email, String password, boolean fired, Long id);
}
