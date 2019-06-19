package ru.raiffeisen.ipr.dto;

public class UpdatePartnerDTO {
    private Long id;
    private String requirements;

    UpdatePartnerDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
}
