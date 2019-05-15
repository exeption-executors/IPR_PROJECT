package Entity;


import javax.persistence.*;


@Entity
@Table(name = "plan", schema = "public", catalog = "ipr")
public class PlanEntity {
    private int id;
    private String planDescription;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "plan_description")
    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanEntity that = (PlanEntity) o;

        if (id != that.id) return false;
        if (planDescription != null ? !planDescription.equals(that.planDescription) : that.planDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (planDescription != null ? planDescription.hashCode() : 0);
        return result;
    }
}
