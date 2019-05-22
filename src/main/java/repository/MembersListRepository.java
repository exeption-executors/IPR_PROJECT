package repository;

import entity.MembersList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersListRepository extends JpaRepository<MembersList, Integer> {
}
