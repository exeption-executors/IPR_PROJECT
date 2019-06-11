package rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import ru.raiffeisen.ipr.Application;
import ru.raiffeisen.ipr.dto.ClientDTO;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.mappers.ClientMapper;
import ru.raiffeisen.ipr.service.ClientService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ComponentScan(basePackages = {"ru.raiffeisen.ipr.service.impl"})
@EnableJpaRepositories(basePackages = {"ru.raiffeisen.ipr.repository"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@EntityScan
public class ClientDTOTest {

    @Test
    public void ClientToClientDTOTest() {
        Client clientEntity = new Client();
        clientEntity.setName("john");
        clientEntity.setSurname("nash");
        clientEntity.setEmail("sdfsdfwdf");
        clientEntity.setFired(false);

        ClientDTO clientDTO = ClientMapper.fromClientEntityToClientDTO(clientEntity);
        assertEquals("john", clientDTO.getName());
        assertEquals("nash", clientDTO.getSurname());
        assertEquals("sdfsdfwdf", clientDTO.getEmail());
        assertFalse(clientDTO.getFired());

    }

    @Test
    public void ClientDTOToClientEntityTest() {
        ClientDTO clientDTO= new ClientDTO();
        clientDTO.setName("john");
        clientDTO.setSurname("nash");
        clientDTO.setEmail("sdfsdfwdf");
        clientDTO.setFired(false);

        Client client = ClientMapper.fromClientDTOToClientEntity(clientDTO);
        assertEquals("john", client.getName());
        assertEquals("nash", client.getSurname());
        assertEquals("sdfsdfwdf", client.getEmail());
        assertEquals("john", client.getName());
        assertFalse(client.getFired());
    }
}
