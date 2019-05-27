package service;

public interface ClientService {
    void addClient(String name, String surname, String email, boolean fired);
    Integer getIdByName(String name);
    //void delete(Integer id);
    //Client editClient(Client client);
    //List<Client> getAll();

}
