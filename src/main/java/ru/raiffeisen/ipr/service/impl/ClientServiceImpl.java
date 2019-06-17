package ru.raiffeisen.ipr.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.raiffeisen.ipr.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.repository.ClientRepository;
import ru.raiffeisen.ipr.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void deleteClientByEmail(String email) {
        clientRepository.delete(clientRepository.findByEmail(email));
    }

    @Override
    public Optional<Client> findById(Long id) {
       return clientRepository.findById(id);
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

}