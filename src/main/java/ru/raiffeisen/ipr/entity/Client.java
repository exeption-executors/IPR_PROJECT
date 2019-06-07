package ru.raiffeisen.ipr.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.*;

@Entity(name = "Client")
@Table(name = "client", schema = "public", catalog = "ipr")
public class Client {
    public Client() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "fired")
    private boolean fired;

    @Fetch(FetchMode.JOIN)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "client_id", nullable = false)
    private List<Plan> planEntities;

    public void addPlanEntity(Plan plan) {
        this.planEntities.add(plan);
    }

    @Fetch(FetchMode.JOIN)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "members_clients",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "members_list_id")
    )
    private Set<MembersList> allIncludedMembersList = new HashSet<>();

    public Set<MembersList> getAllIncludedMembersList() {
        return allIncludedMembersList;
    }

    public void setAllIncludedMembersList(Set<MembersList> allIncludedMembersList) {
        this.allIncludedMembersList = allIncludedMembersList;
    }

    public void addMembersListToClient(MembersList membersList) {
        allIncludedMembersList.add(membersList);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Plan> getPlanEntities() {
        return planEntities;
    }

    public void setPlanEntities(List<Plan> planEntities) {
        this.planEntities = planEntities;
    }

}