package ru.raiffeisen.ipr.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "section", schema = "public", catalog = "ipr")
public class Section {
    public Section() {

    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "section_date_end")
    private Date sectionDateEnd;

    @Basic
    @Column(name = "section_description")
    private String sectionDescription;

    @Basic
    @Column(name = "priority")
    private String priority;

    @Fetch(FetchMode.JOIN)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "section_id", nullable = false)
    private List<Point>  points;

    @OneToOne(mappedBy = "section", cascade = CascadeType.MERGE)
    private Partner partner;

    public void addPointEntity(Point point) {
        points.add(point);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSectionDateEnd() {
        return sectionDateEnd;
    }

    public void setSectionDateEnd(Date sectionDateEnd) {
        this.sectionDateEnd = sectionDateEnd;
    }

    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> pointEntities) {
        this.points = pointEntities;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}