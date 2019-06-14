package ru.raiffeisen.ipr.repository;

import org.springframework.stereotype.Repository;
import ru.raiffeisen.ipr.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
