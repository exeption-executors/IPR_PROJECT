package repository;

import entity.TasksListEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TasksListRepository extends JpaRepository<TasksListEntity, Integer> {
}
