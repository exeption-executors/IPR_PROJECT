package Entity;

import javax.persistence.*;


@Entity
@Table(name = "task", schema = "public", catalog = "ipr")
public class TaskEntity {
    private int id;
    private String taskDescription;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        TaskEntity that = (TaskEntity) o;

        if (id != that.id) return false;
        if (taskDescription != null ? !taskDescription.equals(that.taskDescription) : that.taskDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (taskDescription != null ? taskDescription.hashCode() : 0);
        return result;
    }
}
