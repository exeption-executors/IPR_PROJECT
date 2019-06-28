package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import context.RestContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.raiffeisen.ipr.dto.*;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.PlanService;

import java.sql.Date;
import java.util.*;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestContext.class)
@AutoConfigureMockMvc
public class PlanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PlanService planService;

    @Autowired
    ClientService clientService;

    @Before
    public void createFakePlan() throws Exception {
        CreatePlanDTO createPlanDTO = new CreatePlanDTO();
        CreateSectionDTO createSectionDTO = new CreateSectionDTO();
        createPlanDTO.setClient_id((long) 1);
        createPlanDTO.setPlanDateStart(Date.valueOf("2010-05-15"));
        createPlanDTO.setPlanDateEnd(Date.valueOf("2022-09-20"));
        createSectionDTO.setPriority("High");
        createSectionDTO.setSectionDateEnd(Date.valueOf("2020-06-25"));
        createSectionDTO.setSectionDescription("Fake");

        createPlanDTO.setSectionDTO(Arrays.asList(createSectionDTO));
        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(createPlanDTO);

        mockMvc.perform(post("/plans").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldCreatePlan() throws Exception {
        CreatePlanDTO createPlanDTO = new CreatePlanDTO();
        CreateSectionDTO createSectionDTO = new CreateSectionDTO();
        createPlanDTO.setClient_id((long) 1);
        createPlanDTO.setPlanDateStart(Date.valueOf("2019-02-07"));
        createPlanDTO.setPlanDateEnd(Date.valueOf("2020-07-17"));
        createSectionDTO.setPriority("Low");
        createSectionDTO.setSectionDateEnd(Date.valueOf("2020-06-25"));
        createSectionDTO.setSectionDescription("NewSection");

        createPlanDTO.setSectionDTO(Arrays.asList(createSectionDTO));

        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(createPlanDTO);

        mockMvc.perform(post("/plans").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isCreated());

        Optional<Plan> plan = planService.findById((long) 2);

        Optional<Client> client = clientService.findById(createPlanDTO.getClient_id());

        System.out.println(client.get());

        assertNotNull(plan.get().getId());
        assertEquals(2,client.get().getPlanEntities().size());
    }


    @Test
    public void shouldDeletePlan() throws Exception {

        PlanDeleteDTO planDeleteDTO = new PlanDeleteDTO();
        planDeleteDTO.setId((long) 2);

        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(planDeleteDTO);

        mockMvc.perform(delete("/plans").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk());

        Optional<Plan> plan = planService.findById((long) 2);

        assertEquals(false, plan.isPresent());
    }

}
