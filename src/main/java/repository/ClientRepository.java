package repository;

import entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, String> {

 /*   @Query("select * from ClientEntity = ")
    ClientEntity getAll(@Param(""))*/
}
