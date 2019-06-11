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
    private List<TasksList>  allIncludedTasksList;

    @OneToOne(mappedBy = "section", cascade = CascadeType.ALL)
    private MembersList membersList;

    public MembersList getMembersList() {
        return membersList;
    }


    public void setMembersList(MembersList membersList) {
        if (membersList == null) {
            if (this.membersList != null) {
                this.membersList.setSection(null);
            }
        }
        else {
            membersList.setSection(this);
        }
        this.membersList = membersList;
    }

    public void addTasksList(TasksList tasksList) {
        allIncludedTasksList.add(tasksList);
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

    public List<TasksList> getAllIncludedTasksList() {
        return allIncludedTasksList;
    }

    public void setAllIncludedTasksList(List<TasksList> allIncludedTasksList) {
        this.allIncludedTasksList = allIncludedTasksList;
    }
}