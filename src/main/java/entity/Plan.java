package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "Plan")
@Table(name = "plan", schema = "public", catalog = "ipr")
public class Plan {
    public Plan() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "plan_date_start")
    private Date planDateStart;

    @Basic
    @Column(name = "plan_date_end")
    private Date planDateEnd;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "plan_id", nullable = false)
    private List<PlanTasks> planTasksEntities;


    public void addPlanTasksEntity(PlanTasks planTasks) {
        planTasksEntities.add(planTasks);
    }

    public List<PlanTasks> getPlanTasksEntities() {
        return planTasksEntities;
    }

    public void setPlanTasksEntities(List<PlanTasks> planTasksEntities) {
        this.planTasksEntities = planTasksEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}