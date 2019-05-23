package repository;

import entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("select name from Client name where name.name = :name")
    Client findByName(@Param("name")String name);
}