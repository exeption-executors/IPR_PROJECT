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
    private int id;

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
    @JoinColumn(name = "plan_tasks_id")
    private List<TasksList>  allIncludedTasksList;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "plan_tasks_id", nullable = false)
//    private List<MembersList> membersListEntities;

//    public void addMembersListEntity(MembersList membersList) {
//        this.membersListEntities.add(membersList);
//    }

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanTasks that = (PlanTasks) o;

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

}
