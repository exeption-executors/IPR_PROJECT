package com.example.hiberanate.service;

import com.example.hiberanate.entity.Client;
import com.example.hiberanate.entity.Plan;
import com.example.hiberanate.repository.implementation.ClientRepositoryImplementation;
import org.hibernate.query.Query;

import java.util.List;

public class ClientService {
    private static ClientRepositoryImplementation clientRepository;

    public ClientService() {
        clientRepository = new ClientRepositoryImplementation();
    }

    public void update(Client client) {
        clientRepository.openCurrentSessionWithTransaction();
        clientRepository.updateClient(client);
        clientRepository.closeCurrentSessionWithTransaction();
    }

    public void merge(Client client) {
        clientRepository.openCurrentSessionWithTransaction();
        clientRepository.mergeClient(client);
        clientRepository.closeCurrentSessionWithTransaction();
    }

    public Client findById(Integer id) {
        clientRepository.openCurrentSession();
        Client client = clientRepository.getClientById(id);
        clientRepository.closeCurrentSession();
        return client;
    }

    public void saveClient(Client client) {
        clientRepository.openCurrentSessionWithTransaction();
        clientRepository.saveClient(client);
        clientRepository.closeCurrentSessionWithTransaction();
    }

    public Client findByEmail(String email) {
        clientRepository.openCurrentSession();
        Query query = clientRepository.getCurrentSession().createQuery("from Client where email=:email");
        query.setParameter("email", email);

        Client client = null;
        if(query.list().size() > 0) {
            client = (Client) query.list().get(0);
        }

        clientRepository.closeCurrentSession();
        return client;
    }

    public void delete(Integer id) {
        clientRepository.openCurrentSessionWithTransaction();
        Client client = clientRepository.getClientById(id);
        clientRepository.deleteClient(client);
        clientRepository.closeCurrentSessionWithTransaction();
    }

    public void addPlanToClient(Client client, Plan plan) {
        clientRepository.openCurrentSession();
        client.addPlanEntity(plan);
        clientRepository.mergeClient(client);
        clientRepository.closeCurrentSession();
    }

    public List<Plan> getClientPlans(Client client) {
        clientRepository.openCurrentSession();
        List<Plan> plans = client.getPlanEntities();
        clientRepository.closeCurrentSession();
        return  plans;
    }

//    public List<Client> findAll() {
//        clientRepository.openCurrentSession();
//        List<Client> Clients = clientRepository.findAll();
//        clientRepository.closeCurrentSession();
//        return Clients;
//    }
//
//    public void deleteAll() {
//        clientRepository.openCurrentSessionWithTransaction();
//        clientRepository.deleteAll();
//        clientRepository.openCurrentSessionWithTransaction();
//    }
}
