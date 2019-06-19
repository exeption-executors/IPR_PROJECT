package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client saveClient(Client client);
    List<Client> getAll();
    Optional<Client> findById(Long id);
    void deleteClientByEmail (String email);
    Client findByEmail(String email);
    List<Client> findOurClient();

}
