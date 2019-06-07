package ru.raiffeisen.ipr.mappers;

import org.modelmapper.ModelMapper;
import ru.raiffeisen.ipr.dto.PlanDTO;
import ru.raiffeisen.ipr.entity.Plan;

public class PlanMapper {
    public  static ModelMapper modelMapper = new ModelMapper();


    public static Plan fromPlanDTOToPlanEntity(PlanDTO planDTO) {
        return  modelMapper.map(planDTO, Plan.class);
    }

    public static PlanDTO fromPlanEntityToPlanDTO(Plan plan) {
        return modelMapper.map(plan, PlanDTO.class);
    }
}
