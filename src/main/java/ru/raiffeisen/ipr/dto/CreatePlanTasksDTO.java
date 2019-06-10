package ru.raiffeisen.ipr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import ru.raiffeisen.ipr.entity.TasksList;

import java.sql.Date;
import java.util.List;

public class CreatePlanTasksDTO {
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date planTasksDateEnd;
    private String priority;
    private String planTasksDescription;

    private List<TasksListDTO> allIncludedTasksList;

    public CreatePlanTasksDTO() {}


    public String getPlanTasksDescription() {
        return planTasksDescription;
    }

    public void setPlanTasksDescription(String planTasksDescription) {
        this.planTasksDescription = planTasksDescription;
    }

    public List<TasksListDTO> getAllIncludedTasksList() {
        return allIncludedTasksList;
    }

    public void setAllIncludedTasksList(List<TasksListDTO> allIncludedTasksList) {
        this.allIncludedTasksList = allIncludedTasksList;
    }

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
}
