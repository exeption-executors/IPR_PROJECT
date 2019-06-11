package ru.raiffeisen.ipr.dto;

import javax.persistence.Id;

public class DeletePlanByIdDTO {

    @Id
    private Long id;

    public DeletePlanByIdDTO() {
    }

    public Long getId() {
        return id;
    }
}
