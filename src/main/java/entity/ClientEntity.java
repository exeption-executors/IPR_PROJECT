package entity;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Client")
@Table(name = "client", schema = "public", catalog = "ipr")
public class ClientEntity {
    public ClientEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "surname")
    private String surname;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "fired")
    private boolean fired;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<PlanEntity> planEntities;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "members_clients",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "members_list_id")
    )
    private Set<MembersListEntity> allIncludesMembersList = new HashSet<>();

    public Set<MembersListEntity> getAllIncludesMembersList() {
        return allIncludesMembersList;
    }

    public void setAllIncludesMembersList(Set<MembersListEntity> allIncludesMembersList) {
        this.allIncludesMembersList = allIncludesMembersList;
    }

    public void addMembersListToClient(MembersListEntity membersList) {
        allIncludesMembersList.add(membersList);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }


    public List<PlanEntity> getPlanEntities() {
        return planEntities;
    }

    public void setPlanEntities(List<PlanEntity> planEntities) {
        this.planEntities = planEntities;
    }

    public void addPlanEntity(PlanEntity planEntity) {
        planEntity.setClientId(id);
        this.planEntities.add(planEntity);
    }
}
