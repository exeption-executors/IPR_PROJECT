package repository;

import entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into Client (name, surname, email, fired) values (:name, :surname, :email, :fired)", nativeQuery = true)
    void insertClient(@Param("name") String name, @Param("surname") String surname, @Param("email") String email, @Param("fired") boolean fired);

}
