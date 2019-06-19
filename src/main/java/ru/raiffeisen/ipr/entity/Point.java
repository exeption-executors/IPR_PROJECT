package ru.raiffeisen.ipr.entity;

import javax.persistence.*;

@Entity
@Table(name = "point", schema = "public", catalog = "ipr")
public class Point {
    public Point() {

    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "point_is_done")
    private boolean pointIsDone;

    @Basic
    @Column(name = "point_description")
    private String pointDescription;


    public String getPointDescription() {
        return pointDescription;
    }

    public void setPointDescription(String pointDescription) {
        this.pointDescription = pointDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getPointIsDone() {
        return pointIsDone;
    }

    public void setPointIsDone(boolean pointIsDone) {
        this.pointIsDone = pointIsDone;
    }

}