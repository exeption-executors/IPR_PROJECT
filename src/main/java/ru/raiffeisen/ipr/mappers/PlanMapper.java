package ru.raiffeisen.ipr.mappers;

import org.modelmapper.ModelMapper;
import ru.raiffeisen.ipr.dto.*;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.entity.Section;

import java.util.ArrayList;
import java.util.List;

public class PlanMapper {
    public  static ModelMapper modelMapper = new ModelMapper();


    public static Plan fromPlanDTOToPlanEntity(PlanDTO planDTO) {
        return  modelMapper.map(planDTO, Plan.class);
    }

    public  static PlanDeleteDTO deletePlanByIdDTO(Plan plan) {
        return modelMapper.map(plan, PlanDeleteDTO.class);
    }

    public static Plan createFullPlan(CreatePlanDTO createPlanDTO) {
        return modelMapper.map(createPlanDTO, Plan.class);
    }

    public static List<Section> createSection(List<CreateSectionDTO> createSectionDTOS){
        List<Section> sectionList = new ArrayList<>();
        for(CreateSectionDTO createSectionDTO: createSectionDTOS) {
            Section section = modelMapper.map(createSectionDTO, Section.class);
            sectionList.add(section);
        }
        return sectionList;
    }
}
