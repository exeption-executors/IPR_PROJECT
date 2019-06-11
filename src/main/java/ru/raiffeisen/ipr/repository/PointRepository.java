package ru.raiffeisen.ipr.repository;

import ru.raiffeisen.ipr.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into point (section_id, point_is_done, point_description) " +
            "values (:section_id, :point_is_done, :point_description)", nativeQuery = true)
    void createPoint(@Param("section_id") Long section_id, @Param("point_is_done") boolean point_is_done,
                     @Param("point_description") String point_description);

    @Modifying
    @Transactional
    @Query("delete from Point i where i.id = :id")
    void deletePointById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update Point set pointIsDone = :point_is_done," +
            " pointDescription =:point_description where id =:id")
    void updatePoint(@Param("point_is_done") boolean point_is_done,
                     @Param("point_description") String point_description,
                     @Param("id") Long id);
}
