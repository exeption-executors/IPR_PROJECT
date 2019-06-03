package ru.raiffeisen.ipr.repository;

import ru.raiffeisen.ipr.entity.MembersList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersListRepository extends JpaRepository<MembersList, Integer> {
}
