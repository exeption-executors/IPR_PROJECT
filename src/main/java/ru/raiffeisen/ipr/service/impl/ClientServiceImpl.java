package ru.raiffeisen.ipr.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.raiffeisen.ipr.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.repository.ClientRepository;
import ru.raiffeisen.ipr.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void insertClient(String name, String surname, String email, String password, boolean fired) {
        clientRepository.insertClient(name, surname, email, password, fired);
    }

    @Override
    public void deleteClientByEmail(String email) {
        clientRepository.deleteClientByEmail(email);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteClientById(id);
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public Client findByName(String name){
        return clientRepository.findByName(name);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void updateClient(String name, String surname, String email, String password, boolean fired, Long id) {
        clientRepository.updateClient(name, surname, email, password, fired, id);
    }
}