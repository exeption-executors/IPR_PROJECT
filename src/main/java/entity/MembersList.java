package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "members_list", schema = "public", catalog = "ipr")
public class MembersList {
    public MembersList() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "requirements")
    private String requirements;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "members_clients",
            joinColumns = @JoinColumn(name = "members_list_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Set<Client> members = new HashSet<>();

    @OneToOne()
    @JoinColumn(name = "plan_tasks_id", nullable = false)
    private PlanTasks planTasks;

    public PlanTasks getPlanTasks() {
        return planTasks;
    }

    public void setPlanTasks(PlanTasks planTasks) {
        this.planTasks = planTasks;
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembersList that = (MembersList) o;

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