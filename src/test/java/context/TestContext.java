package context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories()
@EntityScan()
public class TestContext {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TestContext.class, args);
    }
}
