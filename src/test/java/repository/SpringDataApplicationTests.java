package repository;

import entity.Client;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import repository.ClientRepository;

import java.util.Optional;

@SpringBootTest
public class SpringDataApplicationTests {

//    @Autowired
//    private ClientRepository clientRepository;
//
//    @Test
//    @Transactional
//    public void testFindByFirstNameAndLastName() {
//        Optional<Client> clientOptional = clientRepository.findByFirstNameAndLastName("Alex", "Ivanov");
//    }
}
