package service;

import entity.Client;

import java.util.List;

public interface ClientService {
    Client findByName(String name);
    void insertClient(String name, String surnmame, String email, boolean fired);
    void  deleteClientByEmail (String email);
    List<Client> getAll();

    void deleteClientById(Long id);

    Client getByName(String name);
    Client editClient(Client client);
}
