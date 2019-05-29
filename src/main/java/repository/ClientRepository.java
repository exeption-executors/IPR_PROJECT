package repository;

import entity.Client;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("select c from Client c where c.name = :name")
    Client findByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "insert into Client (name, surname, email, fired) values (:name, :surname, :email, :fired)", nativeQuery = true)
    void insertClient(@Param("name") String name, @Param("surname") String surname, @Param("email") String email, @Param("fired") boolean fired);

    @Modifying
    @Transactional
    @Query("delete from Client u where u.email = :email")
    void deleteClientByEmail(@Param("email") String email);



}