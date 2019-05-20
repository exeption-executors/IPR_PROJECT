package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tasks_list", schema = "public", catalog = "ipr")
public class TasksListEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "plan_tasks_id")
    private int planTaskId;

    @Basic
    @Column(name = "task_is_done")
    private boolean taskIsDone;

    @Basic
    @Column(name = "task_description")
    private String taskDescription;

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTaskIsDone() {
        return taskIsDone;
    }

    public void setTaskIsDone(boolean taskIsDone) {
        this.taskIsDone = taskIsDone;
    }

    public int getPlanTaskId() {
        return planTaskId;
    }

    public void setPlanTaskId(int planTaskId) {
        this.planTaskId = planTaskId;
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
}
