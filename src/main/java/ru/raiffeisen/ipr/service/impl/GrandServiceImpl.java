package ru.raiffeisen.ipr.service.impl;

import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.dto.CreatePlanDTO;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.entity.PlanTasks;
import ru.raiffeisen.ipr.mappers.PlanMapper;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.GrandService;

import java.util.List;

@Service
public class GrandServiceImpl implements GrandService {
    @Override
    public void createFullPlan(CreatePlanDTO createPlanDTO, ClientService clientService) {
        Plan plan = PlanMapper.createFullPlan(createPlanDTO);
        Client client = clientService.findByEmail("первоемыло");
        List<PlanTasks> planTasks = PlanMapper.createPlanTasks(createPlanDTO.getPlanTasksDTOS());
        plan.setPlanTasksEntities(planTasks);
        client.addPlanEntity(plan);
        clientService.saveClient(client);
    }
}
