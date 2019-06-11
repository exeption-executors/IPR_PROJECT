package ru.raiffeisen.ipr.service.impl;

import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.dto.CreatePlanDTO;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.entity.Section;
import ru.raiffeisen.ipr.mappers.PlanMapper;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.GrandService;

import java.util.List;

@Service
public class GrandServiceImpl implements GrandService {
    @Override
    public void createFullPlan(CreatePlanDTO createPlanDTO, ClientService clientService) {
        Plan plan = PlanMapper.createFullPlan(createPlanDTO);
        Client client = clientService.findByEmail("Andrewlev@gmail.com");
        List<Section> section = PlanMapper.createSection(createPlanDTO.getSectionDTOS());
        plan.setSectionEntities(section);
        client.addPlanEntity(plan);
        clientService.saveClient(client);
    }
}
