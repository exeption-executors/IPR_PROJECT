package ru.raiffeisen.ipr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

public class CreatePlanDTO {
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date planDateStart;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date planDateEnd;

    private List<CreatePlanTasksDTO> planTasksDTOS;

    public CreatePlanDTO() {
    }

    public Date getPlanDateStart() {
        return planDateStart;
    }

    public void setPlanDateStart(Date planDateStart) {
        this.planDateStart = planDateStart;
    }

    public Date getPlanDateEnd() {
        return planDateEnd;
    }

    public void setPlanDateEnd(Date planDateEnd) {
        this.planDateEnd = planDateEnd;
    }

    public List<CreatePlanTasksDTO> getPlanTasksDTOS() {
        return planTasksDTOS;
    }

    public void setPlanTasksDTOS(List<CreatePlanTasksDTO> planTasksDTOS) {
        this.planTasksDTOS = planTasksDTOS;
    }

}
