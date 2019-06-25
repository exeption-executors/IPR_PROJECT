package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.rest.ClientController;
import ru.raiffeisen.ipr.service.ClientService;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class ClientMockTest {

    private MockMvc mockMvc;

    @InjectMocks
    ClientController clientController;

    @Mock
    ClientService clientService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(clientController)
                .build();
    }

    @Test
    public void test1() throws Exception {
        Client client = new Client();
        client.setFired(false);
        client.setPassword("sdfsdgsdgs");
        client.setName("adfsdfas");
        client.setSurname("sfsfdsdfsfd");
        client.setEmail("hdsgjsdf@gmail.com");

        when(clientService.saveClient(client)).thenReturn(client);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(client);

        mockMvc.perform(
                post("/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated());
    }
}
