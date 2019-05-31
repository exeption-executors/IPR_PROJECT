package repository;

import entity.TasksList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Repository
public interface TasksListRepository extends JpaRepository<TasksList, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into tasks_list (plan_tasks_id, task_is_done, task_description) " +
            "values (:plan_tasks_id, :task_is_done, :task_description)", nativeQuery = true)
    void createTaskList(@Param("plan_tasks_id") Long plan_tasks_id, @Param("task_is_done") boolean task_is_done,
                      @Param("task_description") String task_description);

    @Modifying
    @Transactional
    @Query("delete from TasksList i where i.id = :id")
    void deleteTaskListById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update TasksList set taskIsDone = :task_is_done," +
            " taskDescription =:task_description where id =:id")
    void updateTaskList(@Param("task_is_done") boolean task_is_done,
                    @Param("task_description") String task_description,
                    @Param("id") Long id);
}
