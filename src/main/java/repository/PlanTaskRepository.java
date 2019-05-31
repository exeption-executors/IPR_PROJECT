package repository;

import entity.PlanTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;


@Repository
public interface PlanTaskRepository extends JpaRepository<PlanTasks, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into plan_tasks (plan_id, plan_tasks_date_end, plan_tasks_description, priority) values (:plan_id, :plan_tasks_date_end, :plan_tasks_description, :priority)", nativeQuery = true)
    void createPlanTask(@Param("plan_id") Long plan_id, @Param("plan_tasks_date_end") Date plan_tasks_date_end, @Param("plan_tasks_description") String plan_tasks_description, @Param("priority") String priority);

    @Modifying
    @Transactional
    @Query("delete from PlanTasks i where i.id = :id")
    void deletePlanTaskById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update PlanTasks set planTasksDateEnd = :plan_tasks_date_end," +
            " planTasksDescription =:plan_tasks_description, priority =:priority where id =:id")
    void updatePlanTask(@Param("plan_tasks_date_end") Date plan_tasks_date_end,
                    @Param("plan_tasks_description") String plan_tasks_description,
                    @Param("priority") String priority,
                    @Param("id") Long id);
}
