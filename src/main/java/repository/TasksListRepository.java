package repository;

import entity.TasksList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TasksListRepository extends JpaRepository<TasksList, Integer> {
}
