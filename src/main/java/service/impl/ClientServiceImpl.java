package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
import service.ClientService;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;


    @Override
    public void addClient(String name, String surname, String email, boolean fired) {
//        return clientRepository.createClient(client);
    }

    @Override
    public Integer getIdByName(String name) {
        return clientRepository.findIdByName(name);
    }

   /* @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }


    @Override
    public Client editClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }
*/


    /*@Override
    public void delete(Integer id) {
        clientRepository.deleteById(id);

    }*/
}
