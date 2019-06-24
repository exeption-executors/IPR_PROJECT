package ru.raiffeisen.ipr.repository;

import ru.raiffeisen.ipr.entity.Client;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Modifying;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;
        import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
//    @Query(value = "SELECT name, surname, email, password, fired FROM Client INNER JOIN Plan AS plan_of_client on(plan_of_client.client_id = client.id)")
//    List<Client> getAllClientsWithoutSupport();

    Optional<Client> findByEmail(String email);

    @Query("SELECT name, surname, email, password, fired FROM Client")
    List<Client> findOurClient();
}