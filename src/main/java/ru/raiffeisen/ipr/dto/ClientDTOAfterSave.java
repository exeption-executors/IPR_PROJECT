package ru.raiffeisen.ipr.dto;

public class ClientDTOAfterSave {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private boolean fired;

    public ClientDTOAfterSave() {
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

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }
}