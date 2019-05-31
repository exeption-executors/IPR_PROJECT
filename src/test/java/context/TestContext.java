package context;

import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
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
@EnableJpaRepositories()
@EntityScan()
public class TestContext {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TestContext.class, args);
    }
}
