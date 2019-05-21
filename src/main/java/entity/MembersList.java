package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "members_list", schema = "public", catalog = "ipr")
public class MembersList {
    public MembersList() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "requirements")
    private String requirements;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "members_clients",
//            joinColumns = @JoinColumn(name = "members_list_id"),
//            inverseJoinColumns = @JoinColumn(name = "client_id")
//    )
//    private Set<Client> clients = new HashSet<>();


    @Basic
    @Column(name = "plan_tasks_id",insertable = false,updatable = false)
    private Integer planTasksList;


    @OneToMany
    @JoinColumn(name = "id", nullable = false, insertable = false,updatable = false)
    private List<Client> members;


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

    public List<Client> getMembers() {
        return members;
    }

    public void setMembers(List<Client> membersListEntities) {
        this.members = members;
    }

//    public Set<Client> getClients() {
//        return clients;
//    }
//
//    public void setClients(Set<Client> clients) {
//        this.clients = clients;
//    }
//
//    public void addClient(Client client) {
//        this.clients.add(client);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembersList that = (MembersList) o;

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
