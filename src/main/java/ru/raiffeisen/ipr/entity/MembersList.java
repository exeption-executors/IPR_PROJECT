package ru.raiffeisen.ipr.entity;

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
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
}