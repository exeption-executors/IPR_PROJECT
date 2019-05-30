package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "plan_tasks", schema = "public", catalog = "ipr")
public class PlanTasks {
    public PlanTasks() {

    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "plan_tasks_date_end")
    private Date planTasksDateEnd;

    @Basic
    @Column(name = "plan_tasks_description")
    private String planTasksDescription;

    @Basic
    @Column(name = "priority")
    private String priority;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "plan_tasks_id", nullable = false)
    private List<TasksList>  allIncludedTasksList;

    @OneToOne(mappedBy = "planTasks", cascade = CascadeType.ALL)
    private MembersList membersList;

    public MembersList getMembersList() {
        return membersList;
    }


    public void setMembersList(MembersList membersList) {
        if (membersList == null) {
            if (this.membersList != null) {
                this.membersList.setPlanTasks(null);
            }
        }
        else {
            membersList.setPlanTasks(this);
        }
        this.membersList = membersList;
    }

    public void addTasksList(TasksList tasksList) {
        allIncludedTasksList.add(tasksList);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getPlanTasksDateEnd() {
        return planTasksDateEnd;
    }

    public void setPlanTasksDateEnd(Date planTasksDateEnd) {
        this.planTasksDateEnd = planTasksDateEnd;
    }

    public String getPlanTasksDescription() {
        return planTasksDescription;
    }

    public void setPlanTasksDescription(String planTasksDescription) {
        this.planTasksDescription = planTasksDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

}