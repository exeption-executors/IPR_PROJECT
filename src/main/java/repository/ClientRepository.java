package repository;

import entity.Client;

import java.io.Serializable;

public interface ClientRepository<T, Id> {
    void saveClient(T client);
    void deleteClient(T client);
    void updateClient(T client);
    T getClientById(Id id);
}
