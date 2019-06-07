package ru.raiffeisen.ipr.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.ipr.dto.ClientDTO;
import ru.raiffeisen.ipr.dto.PlanDTO;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.mappers.ClientMapper;
import ru.raiffeisen.ipr.mappers.PlanMapper;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.PlanService;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private PlanService planService;

/*    public PlanController(PlanService planService){
        this.planService = planService;
    }

    @RequestMapping(value = "/deletelist", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public void deletePlan(@RequestBody PlanDTO planDTO) {
        Plan plan = PlanMapper.fromPlanDTOToPlanEntity(planDTO);
        System.out.println("Удален");
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createPlan(@RequestBody PlanDTO planDTO) {
        Plan plan = PlanMapper.fromPlanDTOToPlanEntity(planDTO);
        System.out.println(plan.getId());
    }*/
}
