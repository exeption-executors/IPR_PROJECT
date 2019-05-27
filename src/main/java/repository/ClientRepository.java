package repository;

import entity.Client;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
        @Query("select id from Client where name = :name")
        Integer findIdByName(String name);

    @Modifying
    @Query(value = "insert into Client (name, surname, email, fired) VALUES (:name, :surname, :email, :fired)", nativeQuery = true)
    @Transactional
    Client createClient (Client client);


}