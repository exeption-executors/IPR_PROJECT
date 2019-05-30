package services;

import application.Application;
import entity.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import service.ClientService;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ComponentScan(basePackages = {"main.java.service"})
@EnableJpaRepositories(basePackages = {"main.java.repository"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@EntityScan
public class ClientServiceTest {
    @Autowired
    ClientService clientService;

    @Test
    public void insertClientIntoDB() {
        clientService.insertClient("Mark", "Bryzgalov", "marik33409@mail.ru", false);

        Client clientFromDB = clientService.findByEmail("marik33409@mail.ru");

        System.out.println("Данные добавленного клиента: " + " " +
                clientFromDB.getName() + " " + clientFromDB.getSurname() + " " +
                clientFromDB.getEmail());
        assertEquals("Mark", clientFromDB.getName());
    }

    @Test
    public void getAllClientsFromDB() {
        clientService.insertClient("Mark", "Bryzgalov", "marik33409@mail.ru", false);
        clientService.insertClient("Andrey", "Levkin", "andrey@gmail.com", false);
        clientService.insertClient("Evgeny", "Davidov", "evgen@yandex.ru", false);

        List<Client> clients = clientService.getAll();
        System.out.println("Количество добавленных клиетов: " + clients.size());
        assertEquals(clients.size(), 3);
    }

    @Test
    public void deleteClientFromDBByEmail() {
        clientService.insertClient("Mark", "Bryzgalov", "marik33409@mail.ru", false);

        Client addedClient = clientService.findByEmail("marik33409@mail.ru");

        System.out.println("Добавлен клиент с email: " + addedClient.getEmail());

        clientService.deleteClientByEmail("marik33409@mail.ru");

        System.out.println("Удален клиент с email: " + addedClient.getEmail());

        Client deletedClient = clientService.findByEmail("marik33409@mail.ru");

        assertNull(deletedClient);
    }

    @Test
    public void findClintByEmail() {
        clientService.insertClient("Andrey", "Levkin", "andrey@gmail.com", false);
        clientService.insertClient("Mark", "Bryzgalov", "marik33409@mail.ru", false);
        clientService.insertClient("Evgeny", "Davidov", "evgen@yandex.ru", false);

        Client addedClient = clientService.findByEmail("marik33409@mail.ru");

        System.out.println("Найден клиент с email: " + addedClient.getEmail());

        assertEquals("marik33409@mail.ru", addedClient.getEmail());
    }

    @Test
    public void updateClient() {
        clientService.insertClient("Andrey", "Levkin", "andrey@gmail.com", false);

        Client clientFromDB = clientService.findByEmail("andrey@gmail.com");

        System.out.println("Данные добавленного клиента: " + " " +
                clientFromDB.getName() + " " + clientFromDB.getSurname() + " " +
                clientFromDB.getEmail());

        clientService.updateClient("Andrew", "Lion", "lionking@mail.ru", true, 1l);

        Client updatedClient = clientService.findByEmail("lionking@mail.ru");

        System.out.println("Обновленные данные клиента: " + " " +
                updatedClient.getName() + " " + updatedClient.getSurname() + " " +
                updatedClient.getEmail());

        assertEquals("Andrew", updatedClient.getName());
        assertEquals("Lion", updatedClient.getSurname());
        assertEquals("lionking@mail.ru", updatedClient.getEmail());
    }
}