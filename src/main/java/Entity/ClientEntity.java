package Entity;

import com.example.jdbc.entity.Client;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "client", schema = "public", catalog = "ipr")
public class ClientEntity {

    public ClientEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
    @Column(name = "vacation_date_from")
    private Date vacationDateFrom;

    @Basic
    @Column(name = "vacation_date_to")
    private Date vacationDateTo;

    //@OneToOne(mappedBy = "ClientEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<PlanEntity> plans;

/*    public ClientEntity(String name, String email){
        this.name = name;
        this.email = email;*/
        //plans = new ArrayList<>();


    public int getId() {
        return id;
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


    public Date getVacationDateFrom() {
        return vacationDateFrom;
    }

    public void setVacationDateFrom(Date vacationDateFrom) {
        this.vacationDateFrom = vacationDateFrom;
    }

    public Date getVacationDateTo() {
        return vacationDateTo;
    }

    public void setVacationDateTo(Date vacationDateTo) {
        this.vacationDateTo = vacationDateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (vacationDateFrom != null ? !vacationDateFrom.equals(that.vacationDateFrom) : that.vacationDateFrom != null)
            return false;
        if (vacationDateTo != null ? !vacationDateTo.equals(that.vacationDateTo) : that.vacationDateTo != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (vacationDateFrom != null ? vacationDateFrom.hashCode() : 0);
        result = 31 * result + (vacationDateTo != null ? vacationDateTo.hashCode() : 0);
        return result;
    }
}
