package com.example.repository;


import com.example.hiberanate.SpringHibernateApplication;
import com.example.hiberanate.entity.Client;
import com.example.hiberanate.entity.Plan;
import com.example.hiberanate.service.ClientService;
import com.example.hiberanate.service.PlanService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringHibernateApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RepositoryTest {
    private static ClientService clientService = new ClientService();
    private static PlanService planService = new PlanService();

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    @Test()
    public void saveClient() {
        Client client = new Client();
        client.setEmail("ADFWSAFSF");
        client.setFired(false);
        client.setName("adfsd");
        client.setSurname("dfdsfsfw");

        clientService.saveClient(client);
        Client clientFromDb = clientService.findByEmail("ADFWSAFSF");

        assertEquals(client.getEmail(), clientFromDb.getEmail());
    }

    @Test()
    public void wirePlanWithClient() throws ParseException {
        Plan plan = new Plan();
        plan.setPlanDateStart(new Date(dateFormat.parse("01/02/1999").getTime()));
        plan.setPlanDateEnd(new Date(dateFormat.parse("02/03/1999").getTime()));

        Client clientFromDb = clientService.findByEmail("ADFWSAFSF");
        clientService.addPlanToClient(clientFromDb, plan);

        assertEquals(1, clientService.getClientPlans(clientFromDb).size());
    }
}
