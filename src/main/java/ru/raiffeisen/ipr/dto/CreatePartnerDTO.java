package ru.raiffeisen.ipr.dto;

public class CreatePartnerDTO {
    private Long section_id;
    private Long client_id;
    private String supportEmail1;
    private String supportEmail2;
    private String supportEmail3;
    private String supportEmail4;
    private String supportEmail5;
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

    public String getSupportEmail2() {
        return supportEmail2;
    }

    public void setSupportEmail2(String supportEmail2) {
        this.supportEmail2 = supportEmail2;
    }

    public String getSupportEmail3() {
        return supportEmail3;
    }

    public void setSupportEmail3(String supportEmail3) {
        this.supportEmail3 = supportEmail3;
    }

    public String getSupportEmail4() {
        return supportEmail4;
    }

    public void setSupportEmail4(String supportEmail4) {
        this.supportEmail4 = supportEmail4;
    }

    public String getSupportEmail5() {
        return supportEmail5;
    }

    public void setSupportEmail5(String supportEmail5) {
        this.supportEmail5 = supportEmail5;
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
