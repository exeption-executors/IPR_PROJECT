package repository;

import entity.MembersListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersListRepository extends JpaRepository<MembersListEntity, Integer> {
}
