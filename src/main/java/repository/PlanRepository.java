package repository;

import entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into plan (client_id, plan_date_start, plan_date_end) values (:client_id, :plan_date_start, :plan_date_end)", nativeQuery = true)
    void createPlan(@Param("client_id") Long client_id, @Param("plan_date_start") Date plan_date_start, @Param("plan_date_end") Date plan_date_end);

}
