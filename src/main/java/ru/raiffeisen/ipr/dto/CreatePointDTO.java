package ru.raiffeisen.ipr.dto;

public class CreatePointDTO {
    private Long section_id;
    private Boolean pointIsDone;
    private String pointDescription;

    public CreatePointDTO() {
    }

    public Long getSection_id() {
        return section_id;
    }

    public void setSection_id(Long section_id) {
        this.section_id = section_id;
    }

    public Boolean getPointIsDone() {
        return pointIsDone;
    }

    public void setPointIsDone(Boolean pointIsDone) {
        this.pointIsDone = pointIsDone;
    }

    public String getPointDescription() {
        return pointDescription;
    }

    public void setPointDescription(String pointDescription) {
        this.pointDescription = pointDescription;
    }
}
