package service;

import entity.ClientEntity;

import java.util.List;

public interface ClientService {
    /*ClientEntity addClientEntity(ClientEntity clientEntity);
    void delete(Integer id);
    ClientEntity getByName(String name);
    ClientEntity editClientEntity(ClientEntity clientEntity);*/
    List<ClientEntity> getAll();
   // List<ClientEntity> findAll();
    //List<ClientEntity> findByName(String name);
}
