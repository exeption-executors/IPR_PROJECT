package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "plan_tasks", schema = "public", catalog = "ipr")
public class PlanTasksEntity {
    private int id;
    private Date planTasksDateEnd;
    private String planTasksDescription;
    private String priority;
    private PlanEntity planByPlanId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "plan_tasks_date_end")
    public Date getPlanTasksDateEnd() {
        return planTasksDateEnd;
    }

    public void setPlanTasksDateEnd(Date planTasksDateEnd) {
        this.planTasksDateEnd = planTasksDateEnd;
    }

    @Basic
    @Column(name = "plan_tasks_description")
    public String getPlanTasksDescription() {
        return planTasksDescription;
    }

    public void setPlanTasksDescription(String planTasksDescription) {
        this.planTasksDescription = planTasksDescription;
    }

    @Basic
    @Column(name = "priority")
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanTasksEntity that = (PlanTasksEntity) o;

        if (id != that.id) return false;
        if (planTasksDateEnd != null ? !planTasksDateEnd.equals(that.planTasksDateEnd) : that.planTasksDateEnd != null)
            return false;
        if (planTasksDescription != null ? !planTasksDescription.equals(that.planTasksDescription) : that.planTasksDescription != null)
            return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (planTasksDateEnd != null ? planTasksDateEnd.hashCode() : 0);
        result = 31 * result + (planTasksDescription != null ? planTasksDescription.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id", nullable = false)
    public PlanEntity getPlanByPlanId() {
        return planByPlanId;
    }

    public void setPlanByPlanId(PlanEntity planByPlanId) {
        this.planByPlanId = planByPlanId;
    }
}
