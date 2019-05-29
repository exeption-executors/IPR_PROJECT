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

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ComponentScan(basePackages = {"main.java.service"})
@EnableJpaRepositories(basePackages = {"main.java.repository"})
@EntityScan
public class ClientServiceTest {


    @Autowired
    ClientService clientService;


    @Test(expected = NullPointerException.class)
    public void createPojoToDB() {
        clientService.insertClient("Mark", "Bryzgalov","marik33409@mail.ru", false);

        Client clientFromDB = clientService.findByEmail("marik33409@mairu");

        System.out.println(clientFromDB.getEmail());
        assertEquals("Mark", clientFromDB.getName());
    }
}
