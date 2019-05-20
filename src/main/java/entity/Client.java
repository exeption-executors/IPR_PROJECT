package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Client")
@Table(name = "client", schema = "public", catalog = "ipr")
public class Client {
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "client_id", nullable = false)
    private List<Plan> planEntities;

    public void addPlanEntity(Plan plan) {
        this.planEntities.add(plan);
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "members_clients",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "members_list_id")
    )
    private Set<MembersList> allIncludesMembersList = new HashSet<>();

    public Set<MembersList> getAllIncludesMembersList() {
        return allIncludesMembersList;
    }

    public void setAllIncludesMembersList(Set<MembersList> allIncludesMembersList) {
        this.allIncludesMembersList = allIncludesMembersList;
    }

    public void addMembersListToClient(MembersList membersList) {
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


    public List<Plan> getPlanEntities() {
        return planEntities;
    }

    public void setPlanEntities(List<Plan> planEntities) {
        this.planEntities = planEntities;
    }

}
