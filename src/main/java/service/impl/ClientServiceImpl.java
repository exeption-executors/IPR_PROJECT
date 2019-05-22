//package service.impl;
//
//import entity.Client;
//import entity.ClientEntity;
//import net.bytebuddy.implementation.bytecode.Throw;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import repository.ClientRepository;
//import service.ClientService;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//@Repository
//@Transactional
//public class ClientServiceImpl implements ClientService {
//
//    @Autowired
//    private ClientRepository clientRepository;
//
//    @Override
//    public List<Client> getAll() {
//            return clientRepository.findAll();
//    }
//}
//
//
//
//
//
//   /* public List<ClientService> findByName(String name){
//        return clientRepository.findByName(name);
//    }*/
//
///*    @Override
//    public ClientEntity addClientEntity(ClientEntity clientEntity) {
//        ClientEntity savedClientEntity = clientRepository.saveAndFlush(clientEntity);
//        return savedClientEntity;
//    }
//
//    @Override
//    public ClientEntity editClientEntity(ClientEntity clientEntity) {
//        return clientRepository.saveAndFlush(clientEntity);
//    }
//
//    @Override
//    public List<ClientEntity> getAll() {
//        return clientRepository.findAll();
//    }
//
//    @Override
//    public ClientEntity getByName(String name) {
//        return clientRepository.findById(name);
//    }
//
//    @Override
//    public void delete(Integer id) {
//        clientRepository.deleteById(id);
//
//    }*/
