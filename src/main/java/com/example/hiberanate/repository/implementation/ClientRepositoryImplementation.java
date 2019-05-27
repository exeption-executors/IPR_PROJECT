package com.example.hiberanate.repository.implementation;

import com.example.hiberanate.entity.Client;
import com.example.hiberanate.repository.ClientRepository;

public class ClientRepositoryImplementation extends SessionWorker implements ClientRepository<Client, Integer> {
    @Override
    public void saveClient(Client client) {
        getCurrentSession().save(client);
    }

    @Override
    public void deleteClient(Client client) {
        getCurrentSession().delete(client);
    }

    @Override
    public void updateClient(Client client) {
        getCurrentSession().update(client);
    }

    @Override
    public void mergeClient(Client client) {
        getCurrentSession().merge(client);
    }

    @Override
    public Client getClientById(Integer id) {
        return getCurrentSession().get(Client.class, id);
    }
}