package com.example.jdbc.dao;

import com.example.jdbc.entity.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JdbcTest
@ComponentScan
public class ClientDaoTest {

    private static final String ALICE_NAME = "Alice";
    private static final String ALICE_EMAIL = "alice@test.com";
    private static final String BOB_NAME = "Bob";
    private static final String BOB_EMAIL = "bob@test.com";
    private static final int ONE_Client = 1;
    private static final int TWO_ClientS = 2;

    @Autowired
    private ClientDao ClientDao;

    private Client alice;
    private Client bob;

    @Before
    public void setUp(){
        alice = new Client();
        alice.setName(ALICE_NAME);
        alice.setEmail(ALICE_EMAIL);

        bob = new Client();
        bob.setName(BOB_NAME);
        bob.setEmail(BOB_EMAIL);
    }

    @Test
    public void create_shouldReturnValidClient_whenAddingNewClient() {

        ClientDao.create(alice);

        assertThat(alice.getId()).isNotNull();

        Optional<Client> result = ClientDao.findById(alice.getId());

        System.out.println("Имя --------------");
        System.out.println(result.get().getName());

        assertThat(result).isPresent();
        assertThat(alice).hasFieldOrPropertyWithValue("name", ALICE_NAME);
        assertThat(alice).hasFieldOrPropertyWithValue("email", ALICE_EMAIL);
    }

    @Test
    public void findById_shouldReturnInvalidClient_forEmptyDatabase() {
        Optional<Client> invalidClient = ClientDao.findById(new Random().nextInt());
        assertThat(invalidClient.isPresent()).isFalse();
    }

    @Test
    public void findById_shouldReturnValidClient_forExistingClient() {
        ClientDao.create(alice);

        Optional<Client> validClient = ClientDao.findById(alice.getId());

        assertThat(validClient).isPresent();
        assertThat(validClient.get().getName()).isEqualTo(alice.getName());
        assertThat(validClient.get().getEmail()).isEqualTo(alice.getEmail());
    }

    @Test
    public void findAll_shouldYieldEmptyList_forEmptyDatabase() {
        List<Client> noClients = ClientDao.findAll();
        assertThat(noClients).isNullOrEmpty();
    }

    @Test
    public void findAll_shouldYieldListOfClients_forNonemptyDatabase() {

        ClientDao.create(alice);
        List<Client> Clients = ClientDao.findAll();

        assertThat(Clients).isNotNull().hasSize(ONE_Client);

        Client result = Clients.get(0);

        assertThat(result).hasFieldOrPropertyWithValue("name", ALICE_NAME);
        assertThat(result).hasFieldOrPropertyWithValue("email", ALICE_EMAIL);

        ClientDao.create(bob);
        Clients = ClientDao.findAll();

        assertThat(Clients).isNotNull().hasSize(TWO_ClientS);
    }

    @Test
    public void update_shouldYieldFalse_forEmptyDatabase() {
        Client notFound = new Client();
        notFound.setId(new Random().nextInt());
        assertThat(ClientDao.update(notFound)).isFalse();
    }

    @Test
    public void update_shouldYieldTrue_forExistingClient() {
        ClientDao.create(alice);

        assertThat(alice.getId()).isNotNull();
        assertThat(ClientDao.update(alice)).isTrue();

        alice.setName(BOB_NAME);
        alice.setEmail(BOB_EMAIL);
        assertThat(ClientDao.update(alice)).isTrue();

        Optional<Client> found = ClientDao.findById(alice.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo(alice.getName());
        assertThat(found.get().getEmail()).isEqualTo(alice.getEmail());
    }

    @Test
    public void delete_shouldYieldFalse_forEmptyDatabaseOrNonexistingClient() {
        assertThat(ClientDao.delete(new Random().nextInt())).isFalse();
    }

    @Test
    public void delete_shouldYieldTrue_forExistingClient() {
        ClientDao.create(alice);
        assertThat(ClientDao.findAll()).hasSize(ONE_Client);
        assertThat(ClientDao.delete(alice.getId())).isTrue();
        assertThat(ClientDao.findById(alice.getId()).isPresent()).isFalse();
        assertThat(ClientDao.findAll()).isEmpty();
    }
}