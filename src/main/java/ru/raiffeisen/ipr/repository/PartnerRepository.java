package ru.raiffeisen.ipr.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.raiffeisen.ipr.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    @Modifying
    @Transactional
    @Query("update Partner set requirements = :requirements where id =:id")
    void updatePartner(@Param("requirements") String requirements,
                     @Param("id") Long id);
}
