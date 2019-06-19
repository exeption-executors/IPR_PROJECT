package ru.raiffeisen.ipr.dto;

public class PartnerDTO {
    private String name;
    private String requirements;

    public PartnerDTO(String name, String requirements) {
        this.name = name;
        this.requirements = requirements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
}
