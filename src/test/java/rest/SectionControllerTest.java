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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.raiffeisen.ipr.dto.CreatePlanDTO;
import ru.raiffeisen.ipr.dto.CreateSectionDTO;
import ru.raiffeisen.ipr.dto.DeleteSectionByIdDTO;
import ru.raiffeisen.ipr.dto.PostSectionDTO;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.service.PlanService;
import ru.raiffeisen.ipr.service.SectionService;

import java.sql.Date;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestContext.class)
@AutoConfigureMockMvc
public class SectionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    SectionService sectionService;

    @Autowired
    PlanService planService;


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

        this.mockMvc.perform(post("/plans").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldAddSection() throws Exception {
        PostSectionDTO postSectionDTO = new PostSectionDTO();

        postSectionDTO.setPlan_id((long) 1);
        postSectionDTO.setPriority("Low");
        postSectionDTO.setSectionDateEnd(Date.valueOf("2019-06-26"));
        postSectionDTO.setSectionDescription("Finish sprint");

        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(postSectionDTO);

        this.mockMvc.perform(post("/section").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isCreated());

        Optional<Plan> plan = planService.findById(postSectionDTO.getPlan_id());

        System.out.println(plan.get().getSectionEntities());
        assertEquals(2, plan.get().getSectionEntities().size());
    }

    @Test
    public void shouldDeleteSection() throws Exception {

        DeleteSectionByIdDTO deleteSectionByIdDTO = new DeleteSectionByIdDTO();
        deleteSectionByIdDTO.setId((long) 1);

        deleteSectionByIdDTO.setId(deleteSectionByIdDTO.getId());

        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(deleteSectionByIdDTO);

        this.mockMvc.perform(delete("/section").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk());

        Optional<Plan> plan = planService.findById(deleteSectionByIdDTO.getId());

        assertEquals(1, plan.get().getSectionEntities().size());
    }
}
