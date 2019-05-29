package application;

import entity.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import repository.ClientRepository;
import service.ClientService;
import service.impl.ClientServiceImpl;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"repository"})
@EntityScan(basePackages = {"entity"})
@ComponentScan(basePackages = "service")
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        ClientService clientService = context.getBean(ClientService.class);
//        clientService.insertClient("Mark", "Bryzgalov","marik33409@mail.ru", false);
//        clientService.insertClient("Andrey", "Levkin", "Andrey@mail.r", false);
//        clientService.insertClient("Evgeny", "Davidov", "evgen@mail.ru",false);
//        Client client = clientService.findByName("Andrey");
//        System.out.println("ID Клиента: "+ client.getId() +" Почта клиента: " + client.getEmail());
//        clientService.deleteClientByEmail("Andrey@mail.r");
        List<Client> clients = clientService.getAll();


    }
}
