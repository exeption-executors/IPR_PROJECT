package ru.raiffeisen.ipr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.dto.CreatePlanDTO;
import ru.raiffeisen.ipr.dto.PostSectionDTO;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.entity.Section;
import ru.raiffeisen.ipr.mappers.PlanMapper;
import ru.raiffeisen.ipr.mappers.SectionMapper;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.GrandPostService;
import ru.raiffeisen.ipr.service.PlanService;
import ru.raiffeisen.ipr.service.exeption.ClientNotFoundException;
import ru.raiffeisen.ipr.service.exeption.PlanNotFoundException;

import java.util.List;

@Service
public class GrandPostServiceImpl implements GrandPostService {

    @Override
    public void createFullPlan(CreatePlanDTO createPlanDTO, ClientService clientService) {
        Plan plan = PlanMapper.createFullPlan(createPlanDTO);
        Client client = clientService.findById(createPlanDTO.getClient_id())
                .orElseThrow(() -> { throw new ClientNotFoundException();
                });
        List<Section> section = PlanMapper.createSection(createPlanDTO.getSectionDTO());
        plan.setSectionEntities(section);
        client.addPlanEntity(plan);
        clientService.updateGrand(client);
    }
}
