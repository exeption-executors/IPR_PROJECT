package service.impl;

import entity.Client;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
import service.ClientService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Repository
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
    public Client getByName(String name) {
        return clientRepository.findByName(name);
    }

    /*@Override
    public void delete(Integer id) {
        clientRepository.deleteById(id);

    }*/
}
