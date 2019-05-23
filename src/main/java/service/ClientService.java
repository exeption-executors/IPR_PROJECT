package service;

import entity.Client;
import repository.implementation.ClientRepositoryImplementation;

import java.util.List;

public class ClientService {
    private static ClientRepositoryImplementation clientRepository;

    public ClientService() {
        clientRepository = new ClientRepositoryImplementation();
    }

    public void update(Client client) {
        clientRepository.openCurrentSessionwithTransaction();
        clientRepository.updateClient(client);
        clientRepository.closeCurrentSessionwithTransaction();
    }

    public Client findById(Integer id) {
        clientRepository.openCurrentSession();
        Client Client = clientRepository.getClientById(id);
        clientRepository.closeCurrentSession();
        return Client;
    }

    public void delete(Integer id) {
        clientRepository.openCurrentSessionwithTransaction();
        Client Client = clientRepository.getClientById(id);
        clientRepository.deleteClient(Client);
        clientRepository.closeCurrentSessionwithTransaction();
    }

//    public List<Client> findAll() {
//        clientRepository.openCurrentSession();
//        List<Client> Clients = clientRepository.findAll();
//        clientRepository.closeCurrentSession();
//        return Clients;
//    }
//
//    public void deleteAll() {
//        clientRepository.openCurrentSessionwithTransaction();
//        clientRepository.deleteAll();
//        clientRepository.closeCurrentSessionwithTransaction();
//    }
}
