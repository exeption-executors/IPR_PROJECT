package ru.raiffeisen.ipr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class CreatePlanTasksDTO {
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date planTasksDateEnd;
    private String priority;
    private String planTasksDescription;

    public CreatePlanTasksDTO() {}

    public Date getPlanTasksDateEnd() {
        return planTasksDateEnd;
    }

    public void setPlanTasksDateEnd(Date planTasksDateEnd) {
        this.planTasksDateEnd = planTasksDateEnd;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getplanTasksDescription() {
        return planTasksDescription;
    }

    public void setplanTasksDescription(String planTasksDescription) {
        this.planTasksDescription = planTasksDescription;
    }
}
