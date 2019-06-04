package ru.raiffeisen.ipr.repository;

import ru.raiffeisen.ipr.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into Client (name, surname, email, password, fired) " +
            "values (:name, :surname, :email, :password, :fired)", nativeQuery = true)
    void insertClient(@Param("name") String name, @Param("surname") String surname,
                      @Param("email") String email, @Param("password") String password,
                      @Param("fired") boolean fired);

    @Modifying
    @Transactional
    @Query("delete from Client e where e.email = :email")
    void deleteClientByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query("delete from Client i where i.id = :id")
    void deleteClientById(@Param("id") Long id);


    @Query("select e from Client e where e.email= :email")
    Client findByEmail(@Param("email") String email);


    @Query("select n from Client n where n.name = :name")
    Client findByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("update Client set name = :name, surname = :surname, email = :email, password = :password, " +
            "fired = :fired where id = :id")
    void updateClient(@Param("name") String name, @Param("surname") String surname,
                      @Param("email") String email, @Param("password") String password,
                      @Param("fired") boolean fired, @Param("id") Long id);
}