package ru.raiffeisen.ipr.dto;

public class PointDTO {
    private Boolean pointIsDone;
    private String pointDescription;

    PointDTO() {
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
