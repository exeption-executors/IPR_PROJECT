package ru.raiffeisen.ipr.repository;

import ru.raiffeisen.ipr.entity.Client;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Modifying;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;
        import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
//    @Query(value = "SELECT name, surname, email, password, fired FROM Client INNER JOIN Plan AS plan_of_client on(plan_of_client.client_id = client.id)")
//    List<Client> getAllClientsWithoutSupport();

    void deleteClientByEmail(String email);

    Client findByEmail(String email);

    Client findByName(String name);

    @Query("SELECT name, surname, email, password, fired FROM Client")
    List<Client> findOurClient();
}