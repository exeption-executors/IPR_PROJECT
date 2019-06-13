package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client saveClient(Client client);
    void deleteClientByEmail (String email);
    Optional<Client> findById(Long id);
    Client findByEmail(String email);
    List<Client> getAll();
}
