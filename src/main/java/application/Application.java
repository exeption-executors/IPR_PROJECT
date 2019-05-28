package application;

import entity.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.ClientRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"repository"})
@EntityScan(basePackages = {"entity"})
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        Client client = new Client();
        client.setEmail("1123");
        client.setName("1111");
        client.setSurname("2222");
        client.setFired(false);
        clientRepository.save(client);
    }
}
