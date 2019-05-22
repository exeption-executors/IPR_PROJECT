package repository;

import entity.PlanTasks;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlanTaskRepository extends JpaRepository<PlanTasks, Integer> {
}
