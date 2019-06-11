package ru.raiffeisen.ipr.repository;

import ru.raiffeisen.ipr.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;


@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into section (plan_id, section_date_end, section_description, priority) values (:plan_id, :section_date_end, :section_description, :priority)", nativeQuery = true)
    void createSection(@Param("plan_id") Long plan_id, @Param("section_date_end") Date section_date_end, @Param("section_description") String section_description, @Param("priority") String priority);

    @Modifying
    @Transactional
    @Query("delete from Section i where i.id = :id")
    void deleteSectionById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update Section set sectionDateEnd = :section_date_end," +
            " sectionDescription =:section_description, priority =:priority where id =:id")
    void updateSection(@Param("section_date_end") Date section_date_end,
                       @Param("section_description") String section_description,
                       @Param("priority") String priority,
                       @Param("id") Long id);
}
