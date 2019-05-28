package application;

import entity.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import repository.ClientRepository;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);
        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        Client client = new Client();
        client.setEmail("1123");
        client.setName("1111");
        client.setSurname("2222");
        client.setFired(false);
        clientRepository.save(client);
    }
}
