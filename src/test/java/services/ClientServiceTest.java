package services;


import context.TestContext;
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
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import repository.ClientRepository;
import service.ClientService;
import service.impl.ClientServiceImpl;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestContext.class)
@TestPropertySource(locations="resources.application.properties")
public class ClientServiceTest {
    ClientService clientService = new ClientServiceImpl();

    @Test
    public void saveClientTest() {
        clientService.insertClient("Mark", "Bryzgalov", "marik33409@mail.ru", false);

        Client clientFromDB = clientService.findByEmail("marik33409@mail.ru");

        System.out.println("Данные добавленного клиента: " + clientFromDB.getName()
                + " " + clientFromDB.getSurname() + " " + clientFromDB.getEmail());

        assertEquals("Mark", clientFromDB.getName());

//        clientService.deleteClientByEmail("marik33409@mail.ru");

    }

   /* @Test(expected = NullPointerException.class)
    public void saveClientTest() {
        clientService.insertClient("Mark", "Bryzgalov", "marik33409@mail.ru", false);

        Client clientFromDB = clientService.findByEmail("marik33409@mai.ru");

        System.out.println(clientFromDB.getEmail());

        assertEquals("Mark", clientFromDB.getName());
    }*/
}
