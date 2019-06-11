package ru.raiffeisen.ipr.service.impl;

import com.google.common.collect.Lists;
import org.springframework.transaction.annotation.Transactional;
import ru.raiffeisen.ipr.dto.ClientDTO;
import ru.raiffeisen.ipr.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.repository.ClientRepository;
import ru.raiffeisen.ipr.service.ClientService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void deleteClientByEmail(String email) {
        clientRepository.delete(clientRepository.findByEmail(email));
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public Client findByName(String name) {
        return clientRepository.findByName(name);
    }

    @Override
    public List<Client> getAll() {
//        return clientRepository.findAll().stream().map(ClientDTO::from).collect(Collectors.toList());
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void updateClient(String name, String surname, String email, String password, boolean fired, Long id) {
        clientRepository.updateClient(name, surname, email, password, fired, id);
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}