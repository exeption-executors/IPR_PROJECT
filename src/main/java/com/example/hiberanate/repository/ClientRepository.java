package com.example.hiberanate.repository;

public interface ClientRepository<T, Id> {
    void saveClient(T client);
    void deleteClient(T client);
    void updateClient(T client);
    void mergeClient(T client);
    T getClientById(Id id);
}
