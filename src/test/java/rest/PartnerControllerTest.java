package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Assert;
import org.mockito.ArgumentMatchers.*;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CorsFilter;
import ru.raiffeisen.ipr.dto.CreatePartnerDTO;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Partner;
import ru.raiffeisen.ipr.rest.PartnerController;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.PartnerService;
import ru.raiffeisen.ipr.service.SectionService;
import ru.raiffeisen.ipr.service.impl.PartnerServiceImpl;

import java.awt.*;
import java.util.Iterator;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class PartnerControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    PartnerController partnerController;

    @Mock
    PartnerService partnerService;

    @Mock
    SectionService sectionService;

    @Mock
    ClientService clientService;

    CreatePartnerDTO createPartnerDTO;



    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(partnerController)
                .build();
    }

    @Test
    public void test_create_user_success() throws Exception {
        Client client = new Client();
        client.setFired(false);
        client.setPassword("sdfsdgsgsdgs");
        client.setName("adfsdfas");
        client.setSurname("sfsfdsdfsdfsfd");
        client.setEmail("hdsgjsdf@gmail.com");

        when(clientService.saveClient(client)).thenReturn(client);
        doNothing().when(clientService).saveClient(client);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(client);

        mockMvc.perform(
                post("/users")
                        .content(requestJson))
                .andExpect(status().isCreated());
    }
}