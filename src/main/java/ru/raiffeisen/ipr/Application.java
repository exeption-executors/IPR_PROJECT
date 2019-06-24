package ru.raiffeisen.ipr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.PlanService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories()
@EntityScan()
public class Application {
    public static void main(String[] args) throws ParseException {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        ClientService clientService = context.getBean(ClientService.class);
        PlanService planService = context.getBean(PlanService.class);
    }
}
