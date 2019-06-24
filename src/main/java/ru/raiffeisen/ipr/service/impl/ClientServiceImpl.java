package ru.raiffeisen.ipr.service.impl;

import ru.raiffeisen.ipr.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.repository.ClientRepository;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.exeption.ClientNotFoundException;
import ru.raiffeisen.ipr.service.exeption.ExistClientException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void deleteClientByEmail(String email) {
        Optional<Client> client = clientRepository.findByEmail(email);
        client.orElseThrow(ClientNotFoundException::new);
        clientRepository.delete(client.get());
    }

    @Override
    public Optional<Client> findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        client.orElseThrow(ClientNotFoundException::new);
        return client;
    }

    @Override
    public List<Client> getAll() {
        List<Client> clientList = clientRepository.findAll();
        if (clientList.isEmpty()){
            throw new ClientNotFoundException();
        }
        return clientList;
    }

    @Override
    public Client saveClient(Client client) {
        Optional<Client> clientFromDB = clientRepository.findByEmail(client.getEmail());
        clientFromDB.ifPresent((Client clientExist) -> {
            throw new ExistClientException(clientExist.getEmail());
        });
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public Client updateClient(Client client) {
        Optional<Client> clientFromDB = clientRepository.findByEmail(client.getEmail());
        if(!clientFromDB.isPresent()) {
            throw new ClientNotFoundException();
        } else {
            return  clientRepository.save(client);
        }
    }

    @Override
    public List<Client> findOurClient() {
        return clientRepository.findOurClient();
    }
}