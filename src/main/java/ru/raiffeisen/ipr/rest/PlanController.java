package ru.raiffeisen.ipr.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.ipr.dto.*;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.mappers.PlanMapper;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.GrandPostService;
import ru.raiffeisen.ipr.service.PlanService;

@RestController
@RequestMapping("/plans")
public class PlanController {
    private PlanService planService;
    private ClientService clientService;
    private GrandPostService grandPostService;

    public PlanController(PlanService planService, ClientService clientService, GrandPostService grandPostService){
        this.planService = planService;
        this.clientService = clientService;
        this.grandPostService = grandPostService;
    }

    /**------ADD ALL FIELDS OF PLAN------**/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createFullPlan(@RequestBody CreatePlanDTO createPlanDTO) {
       grandPostService.createFullPlan(createPlanDTO, clientService);
    }

    /**------DELETE PLAN FUNCTION------**/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePlan(@RequestBody Plan plan) {
        PlanDeleteDTO planDeleteDTO = PlanMapper.deletePlanByIdDTO(plan);
        planService.deletePlanById(plan.getId());
    }
    /**-----UPDATE PLAN FUNCTION------**/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void updatePlan(@RequestBody UpdatePlanDTO updatePlanDTO) {
        Plan planForUpdate = PlanMapper.updatePlan(updatePlanDTO);
        planService.savePlan(planForUpdate);
    }


}
