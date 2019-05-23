package repository.implementation;

import entity.Client;
import repository.ClientRepository;

public class ClientRepositoryImplementation extends SessionWorker implements ClientRepository<Client, Integer> {
    @Override
    public void saveClient(Client client) {
        getCurrentSession().save(client);
    }

    @Override
    public void deleteClient(Client client) {
        getCurrentSession().delete(client);
    }

    @Override
    public void updateClient(Client client) {
        getCurrentSession().update(client);
    }

    @Override
    public Client getClientById(Integer id) {
        return (Client) getCurrentSession().get(Client.class, id);
    }
}