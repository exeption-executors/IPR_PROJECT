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
import ru.raiffeisen.ipr.dto.CreatePointDTO;
import ru.raiffeisen.ipr.dto.CreateSectionDTO;
import ru.raiffeisen.ipr.dto.DeletePointDTO;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.entity.Point;
import ru.raiffeisen.ipr.entity.Section;
import ru.raiffeisen.ipr.service.PlanService;
import ru.raiffeisen.ipr.service.PointService;
import ru.raiffeisen.ipr.service.SectionService;

import java.sql.Date;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestContext.class)
@AutoConfigureMockMvc
public class PointControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    SectionService sectionService;

    @Autowired
    PointService pointService;

    @Autowired
    PlanService planService;

    @Before
    public void createFakePlan() throws Exception {
        CreatePlanDTO createPlanDTO = new CreatePlanDTO();

        createPlanDTO.setClient_id((long) 1);
        createPlanDTO.setPlanDateStart(Date.valueOf("2010-05-15"));
        createPlanDTO.setPlanDateEnd(Date.valueOf("2022-09-20"));

        CreateSectionDTO createSectionDTO = new CreateSectionDTO();

        createSectionDTO.setPriority("High");
        createSectionDTO.setSectionDateEnd(Date.valueOf("2020-06-25"));
        createSectionDTO.setSectionDescription("Fake");

        CreatePointDTO createPointDTO = new CreatePointDTO();

        createPointDTO.setPointIsDone(false);
        createPointDTO.setPointDescription("some point");

        createSectionDTO.setPoints(Arrays.asList(createPointDTO));

        createPlanDTO.setSectionDTO(Arrays.asList(createSectionDTO));

        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(createPlanDTO);

        mockMvc.perform(post("/plans").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isCreated());

        Optional<Plan> plan = planService.findById(1L);

    }

    @Test
    public void shouldDeletePoint() throws Exception {
        Optional<Plan> plan = planService.findById(1L);
        DeletePointDTO deletePointDTO = new DeletePointDTO();

        deletePointDTO.setId(1L);

        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(deletePointDTO);

        mockMvc.perform(delete("/point").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk());


        Optional<Section> section = sectionService.findById(1L);

        assertEquals(0,section.get().getPoints().size());

    }
}
