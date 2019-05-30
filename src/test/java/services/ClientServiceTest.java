package services;


import application.Application;
import entity.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import repository.ClientRepository;
import service.ClientService;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ComponentScan(basePackages = {"main.java.service"})
@EnableJpaRepositories(basePackages = {"main.java.repository"})
@EntityScan
public class ClientServiceTest {


    @Autowired
    ClientService clientService;


    @Test
    public void saveClient() {
        clientService.insertClient("Mark", "Bryzgalov","marik33409@mail.ru", false);

        Client clientFromDB = clientService.findByEmail("marik33409@mail.ru");

        System.out.println("Данные добавленного клиента: " + " " +
                clientFromDB.getName() + " " + clientFromDB.getSurname() + " " +
                clientFromDB.getEmail());
        assertEquals("Mark", clientFromDB.getName());
    }

    @Test
    public  void saveTreeClient(){
        clientService.insertClient("Mark", "Bryzgalov", "marik33409@mail.ru", false);
        clientService.insertClient("Andrey", "Levkin", "andrey@gmail.com", false);
        clientService.insertClient("Evreny", "Davidov", "evgen@yand ex.ru", false);

        List<Client> clients = clientService.getAll();
        System.out.println("Количество добавленных клиетов: " + clients.size());
        assertEquals(clients.size(),3);
    }

    @Test
    public void deleteClientByEmail() {
        clientService.insertClient("Mark", "Bryzgalov", "marik33409@mail.ru", false);

        Client addedClient = clientService.findByEmail("marik33409@mail.ru");

        System.out.println("Добавлен клиент с email: " + addedClient.getEmail());

        clientService.deleteClientByEmail("marik33409@mail.ru");

        System.out.println("Удален клиент с email: " + addedClient.getEmail());

        Client deletedClient = clientService.findByEmail("marik33409@mail.ru");

        assertNull(deletedClient);
    }
}
