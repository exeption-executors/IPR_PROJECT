package rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import context.RestContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import ru.raiffeisen.ipr.Application;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.service.ClientService;

import java.util.Objects;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestContext.class)
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ClientService clientService;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = this.mockMvc.perform(get("/clients")).andExpect(status().isOk()).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        String clientJsonString = response.getContentAsString().substring(1, response.getContentAsString().length() - 1);
        Client client = mapper.readValue(clientJsonString, Client.class);
        assertEquals("Andrew", client.getName());
        assertEquals("Levkin", client.getSurname());
        assertEquals("Andrewlev@gmail.com", client.getEmail());
        assertEquals("1820", client.getPassword());
        assertFalse(client.isFired());
    }
}