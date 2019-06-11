package rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import ru.raiffeisen.ipr.dto.PlanDTO;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.mappers.ClientMapper;
import ru.raiffeisen.ipr.service.ClientService;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ComponentScan(basePackages = {"ru.raiffeisen.ipr.service.impl"})
@EnableJpaRepositories(basePackages = {"ru.raiffeisen.ipr.repository"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@EntityScan
public class CreatePlanDTOTest {

    @Test
    public void planDTOGettingJSON() throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("planDateStart", "01/01/2000");
        map.put("planDateEnd", "01/01/2005");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(map);

            System.out.println(jsonResult);

            assertEquals("{\n" +
                    "  \"planDateStart\" : \"01/01/2000\",\n" +
                    "  \"planDateEnd\" : \"01/01/2005\"\n" +
                    "}", jsonResult);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
