package ru.raiffeisen.ipr.dto;

import ru.raiffeisen.ipr.entity.Client;

public class ClientDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private boolean fired;
    private String password;

    public ClientDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public static ClientDTO from(Client client) {
        ClientDTO clientDTO =  new ClientDTO();
        clientDTO.setName(client.getName());
        clientDTO.setSurname(client.getSurname());
        clientDTO.setPassword(client.getPassword());
        clientDTO.setId(client.getId());
        clientDTO.setEmail(client.getEmail());
        return clientDTO;
    }
}
