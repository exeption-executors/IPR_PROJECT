package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Plan")
@Table(name = "plan", schema = "public", catalog = "ipr")
public class PlanEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "plan_date_start")
    private Date planDateStart;

    @Basic
    @Column(name = "plan_date_end")
    private Date planDateEnd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Integer getClientEntity() { return clientEntity.getId(); }

    public void setClientEntity(ClientEntity clientEntity) { this.clientEntity = clientEntity; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanEntity that = (PlanEntity) o;

        if (id != that.id) return false;
        if (planDateStart != null ? !planDateStart.equals(that.planDateStart) : that.planDateStart != null)
            return false;
        if (planDateEnd != null ? !planDateEnd.equals(that.planDateEnd) : that.planDateEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (planDateStart != null ? planDateStart.hashCode() : 0);
        result = 31 * result + (planDateEnd != null ? planDateEnd.hashCode() : 0);
        return result;
    }
}
