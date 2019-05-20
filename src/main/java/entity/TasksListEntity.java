package entity;

import javax.persistence.*;

@Entity
@Table(name = "tasks_list", schema = "public", catalog = "ipr")
public class TasksListEntity {
    private int id;
    private boolean taskIsDone;
    private String taskDescription;
    private PlanTasksEntity planTasksByPlanTasksId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "task_is_done")
    public boolean isTaskIsDone() {
        return taskIsDone;
    }

    public void setTaskIsDone(boolean taskIsDone) {
        this.taskIsDone = taskIsDone;
    }

    @Basic
    @Column(name = "task_description")
    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TasksListEntity that = (TasksListEntity) o;

        if (id != that.id) return false;
        if (taskIsDone != that.taskIsDone) return false;
        if (taskDescription != null ? !taskDescription.equals(that.taskDescription) : that.taskDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (taskIsDone ? 1 : 0);
        result = 31 * result + (taskDescription != null ? taskDescription.hashCode() : 0);
        return result;
    }

/*    @ManyToOne
    @JoinColumn(name = "plan_tasks_id", referencedColumnName = "id", nullable = false)
    public PlanTasksEntity getPlanTasksByPlanTasksId() {
        return planTasksByPlanTasksId;
    }

    public void setPlanTasksByPlanTasksId(PlanTasksEntity planTasksByPlanTasksId) {
        this.planTasksByPlanTasksId = planTasksByPlanTasksId;
    }*/
}
