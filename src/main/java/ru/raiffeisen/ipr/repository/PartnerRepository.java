package ru.raiffeisen.ipr.repository;

import ru.raiffeisen.ipr.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Integer> {
}
