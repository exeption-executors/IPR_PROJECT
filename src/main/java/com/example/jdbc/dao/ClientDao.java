package com.example.jdbc.dao;

import com.example.jdbc.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Create
    public Client create(final Client client) {
        final String sql = "INSERT INTO client (name, email) VALUES (?, ?)";
        final KeyHolder keyHolder = new GeneratedKeyHolder();

        this.jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, client.getName());
            statement.setString(2, client.getEmail());
            return statement;
        }, keyHolder);

        Integer newClientId = keyHolder.getKey().intValue();
        client.setId(newClientId);
        return client;
    }

    // Retrieve
    public List<Client> findAll() {
        final String sql = "SELECT * FROM client";
        return this.jdbcTemplate.query(sql, new ClientMapper());
    }

    // Retrieve
    // Note when no row exists: <https://stackoverflow.com/a/16390624/339302>
    public Optional<Client> findById(Integer id) {
        final String sql = "SELECT id, name, email FROM client WHERE id = ?";

        return this.jdbcTemplate.query(
                sql,
                rs -> rs.next() ?
                        Optional.of(new ClientMapper().mapRow(rs, 1)):
                        Optional.empty(),
                id);
    }

    // Update
    public boolean update(final Client client) {
        final String sql = "UPDATE client SET name=?, email=? WHERE id=?";
        final Object[] params = new Object[]{client.getName(), client.getEmail(), client.getId()};

        return this.jdbcTemplate.update(sql, params) == 1;
    }

    // Delete
    public boolean delete(Integer id) {
        final String sql = "DELETE FROM client WHERE id = ?";
        final Object[] params = new Object[]{id};

        return this.jdbcTemplate.update(sql, params) == 1;
    }

    class ClientMapper implements RowMapper<Client> {
        @Override
        public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
            final Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setName(rs.getString("name"));
            client.setEmail(rs.getString("email"));
            return client;
        }

    }
}