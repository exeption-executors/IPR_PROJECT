package rest;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import ru.raiffeisen.ipr.dto.CreateSectionDTO;
import ru.raiffeisen.ipr.dto.PostSectionDTO;
import ru.raiffeisen.ipr.dto.SectionReturnDTO;
import ru.raiffeisen.ipr.rest.SectionController;
import ru.raiffeisen.ipr.service.PlanService;
import ru.raiffeisen.ipr.service.SectionService;

import java.sql.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class SectionControllerMockTest {

        private MockMvc mockMvc;

        private Date date;

        @InjectMocks
        SectionController sectionController;

        @Mock
        SectionService sectionService;

        @Mock
        PlanService planService;


        @Before
        public void init() {
            MockitoAnnotations.initMocks(this);
            mockMvc = MockMvcBuilders
                    .standaloneSetup(sectionController)
                    .build();
        }

        PostSectionDTO postSectionDTO;

        @Test
        public void createSectionResponse() throws Exception{

            when(sectionService.postSection(postSectionDTO, planService)).thenReturn(new SectionReturnDTO());
            SectionReturnDTO sectionReturnDTO = new SectionReturnDTO();
            Date date = mock(Date.class);
            sectionReturnDTO.setPriority("WowWow");
            sectionReturnDTO.setSectionDateEnd(date);
            sectionReturnDTO.setSectionDescription("adfsdfas");
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
            String requestJson = ow.writeValueAsString(sectionReturnDTO);

            mockMvc.perform(
                    post("/section")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestJson))
                    .andExpect(status().isCreated());


        }
    }
