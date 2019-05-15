package com.example.jdbc.entity;

import java.sql.Date;

public class Client {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Date vacationDateFrom;
    private Date vacationDateTo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getVacationDateFrom() {
        return vacationDateFrom;
    }

    public void setVacationDateFrom(Date vacationDateFrom) {
        this.vacationDateFrom = vacationDateFrom;
    }

    public Date getVacationDateTo() {
        return vacationDateTo;
    }

    public void setVacationDateTo(Date vacationDateTo) {
        this.vacationDateTo = vacationDateTo;
    }
}
