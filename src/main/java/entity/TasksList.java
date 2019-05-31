package entity;

import javax.persistence.*;

@Entity
@Table(name = "tasks_list", schema = "public", catalog = "ipr")
public class TasksList {
    public TasksList() {

    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTaskIsDone() {
        return taskIsDone;
    }

    public void setTaskIsDone(boolean taskIsDone) {
        this.taskIsDone = taskIsDone;
    }

}