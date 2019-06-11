package ru.raiffeisen.ipr.dto;

import javax.persistence.Id;

public class DeleteSectionByIdDTO {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
