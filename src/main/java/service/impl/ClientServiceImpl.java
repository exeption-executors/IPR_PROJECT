package service.impl;

import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
import service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void insertClient(String name, String surnmame, String email, boolean fired) {
        clientRepository.insertClient(name, surnmame, email, fired);
    }

    @Override
    public Client findByName(String name){
        return clientRepository.findByName(name);

    }
    @Override
    public void deleteClientByEmail(String email) {
        clientRepository.deleteClientByEmail(email);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteClientById(id);
    }

    @Override
    public Client getByName(String name) {
        return clientRepository.findByName(name);
    }

    @Override
    public Client editClient(Client client) {
        return null;
    }



}