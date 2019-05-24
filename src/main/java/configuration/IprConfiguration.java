package configuration;

import entity.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import repository.ClientRepository;
import service.ClientService;
import service.impl.ClientServiceImpl;

@Configuration
@ComponentScan(basePackages = {"service"})
@EnableJpaRepositories("repository")
public class IprConfiguration {
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        return sessionFactory;
    }
}
