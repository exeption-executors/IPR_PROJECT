package ru.raiffeisen.ipr.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "partner", schema = "public", catalog = "ipr")
public class Partner {
    public Partner() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "requirements")
    private String requirements;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "support",
            joinColumns = @JoinColumn(name = "partner_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Set<Client> support = new HashSet<>();

    @OneToOne()
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
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