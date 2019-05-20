package entity;

import com.example.jdbc.entity.Client;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "members_list", schema = "public", catalog = "ipr")
public class MembersListEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "requirements")
    private String requirements;

    @OneToOne(mappedBy = "membersList")
    @JoinColumn(name = "plan_id")
    private PlanTasksEntity planTasksId;

    @OneToMany
    @JoinColumn(name = "id")
    private List<ClientEntity> members;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public List<ClientEntity> getMembers() {
        return members;
    }

    public void setMembers(List<ClientEntity> members) {
        this.members = members;
    }

//    public PlanTasksEntity getPlanTasks() {
//        return planTasks;
//    }
//
//    public void setPlanTasks(PlanTasksEntity planTasks) {
//        this.planTasks = planTasks;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembersListEntity that = (MembersListEntity) o;

        if (id != that.id) return false;
        if (requirements != null ? !requirements.equals(that.requirements) : that.requirements != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (requirements != null ? requirements.hashCode() : 0);
        return result;
    }
}
