package ru.raiffeisen.ipr.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @Fetch(FetchMode.JOIN)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "plan_id", nullable = false)
    private List<Section> sectionEntities;

    public void addSectionEntity(Section section) {
        sectionEntities.add(section);
    }

    public List<Section> getSectionEntities() {
        return sectionEntities;
    }

    public void setSectionEntities(List<Section> sectionEntities) {
        this.sectionEntities = sectionEntities;
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

    public void addSectionList(List<Section> sectionList) {
        sectionEntities.addAll(sectionList);
    }

}