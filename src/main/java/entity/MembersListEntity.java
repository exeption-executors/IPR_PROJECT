package entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "members_list", schema = "public", catalog = "ipr")
public class MembersListEntity {
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
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<ClientEntity> clients = new HashSet<>();


    @Basic
    @Column(name = "plan_tasks_id")
    private Integer planTasksList;

    @OneToMany
    @JoinColumn(name = "id")
    private List<ClientEntity> members;

    public Integer getPlanTasksList() {
        return planTasksList;
    }

    public void setPlanTasksList(Integer planTasksList) {
        this.planTasksList = planTasksList;
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

    public List<ClientEntity> getMembers() {
        return members;
    }

    public void setMembers(List<ClientEntity> members) {
        this.members = members;
    }

//    public Set<ClientEntity> getClients() {
//        return clients;
//    }
//
//    public void setClients(Set<ClientEntity> clients) {
//        this.clients = clients;
//    }
//
//    public void addClient(ClientEntity client) {
//        this.clients.add(client);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembersListEntity that = (MembersListEntity) o;

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
