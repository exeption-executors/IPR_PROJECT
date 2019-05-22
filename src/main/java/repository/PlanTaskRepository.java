package repository;

import entity.PlanTasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlanTaskRepository extends JpaRepository<PlanTasksEntity, Integer> {
}
