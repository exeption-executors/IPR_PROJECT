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

    void deleteClientByEmail(String email);

    Client findByEmail(String email);

    Client findByName(String name);

    @Modifying
    @Transactional
    @Query("update Client set name = :name, surname = :surname, email = :email, password = :password, " +
            "fired = :fired where id = :id")
    void updateClient(@Param("name") String name, @Param("surname") String surname,
                      @Param("email") String email, @Param("password") String password,
                      @Param("fired") boolean fired, @Param("id") Long id);
}