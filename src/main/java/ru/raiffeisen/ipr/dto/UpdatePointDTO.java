package ru.raiffeisen.ipr.dto;

public class UpdatePointDTO {
    private Long id;
    private boolean pointIsDone;
    private String pointDescription;

    public  UpdatePointDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPointIsDone() {
        return pointIsDone;
    }

    public void setPointIsDone(boolean pointIsDone) {
        this.pointIsDone = pointIsDone;
    }

    public String getPointDescription() {
        return pointDescription;
    }

    public void setPointDescription(String pointDescription) {
        this.pointDescription = pointDescription;
    }
}
