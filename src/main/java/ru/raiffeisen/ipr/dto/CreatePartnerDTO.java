package ru.raiffeisen.ipr.dto;

public class CreatePartnerDTO {
    private Long section_id;
    private Long client_id;
    private String supportEmail1;
    private String requirements;

    public CreatePartnerDTO() {
    }

    public Long getSection_id() {
        return section_id;
    }

    public void setSection_id(Long section_id) {
        this.section_id = section_id;
    }

    public String getSupportEmail1() {
        return supportEmail1;
    }

    public void setSupportEmail1(String supportEmail1) {
        this.supportEmail1 = supportEmail1;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}
