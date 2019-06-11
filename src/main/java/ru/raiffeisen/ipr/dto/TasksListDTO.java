package ru.raiffeisen.ipr.dto;

public class TasksListDTO {
    private Boolean taskIsDone;
    private String taskDescription;

    TasksListDTO() {}

    public Boolean getTaskIsDone() {
        return taskIsDone;
    }

    public void setTaskIsDone(Boolean tasksIsDone) {
        this.taskIsDone = tasksIsDone;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String tasksDescription) {
        this.taskDescription = tasksDescription;
    }
}
