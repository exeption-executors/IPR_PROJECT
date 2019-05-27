package service.impl;

import entity.Client;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
import service.ClientService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository clientRepository;

  /*  @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client client) {
        Client savedClient = clientRepository.saveAndFlush(client);
        return savedClient;
    }

    @Override
    public Client editClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }*/

    @Override
    public Integer getIdByName(String name) {
        return clientRepository.findIdByName(name);
    }

    /*@Override
    public void delete(Integer id) {
        clientRepository.deleteById(id);

    }*/
}
