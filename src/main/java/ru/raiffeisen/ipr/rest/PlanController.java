package ru.raiffeisen.ipr.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.ipr.dto.*;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.entity.Section;
import ru.raiffeisen.ipr.mappers.ClientMapper;
import ru.raiffeisen.ipr.mappers.PlanMapper;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.GrandService;
import ru.raiffeisen.ipr.service.PlanService;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private PlanService planService;
    private ClientService clientService;
    private GrandService grandService;

    public PlanController(PlanService planService, ClientService clientService, GrandService grandService){
        this.planService = planService;
        this.clientService = clientService;
        this.grandService = grandService;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePlan(@RequestBody DeletePlanByIdDTO plan) {
        System.out.println(plan.getId());
        planService.deletePlanById(plan.getId());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createFullPlan(@RequestBody CreatePlanDTO createPlanDTO) {
       grandService.createFullPlan(createPlanDTO, clientService);
    }
}
