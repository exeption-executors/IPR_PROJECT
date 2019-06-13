package ru.raiffeisen.ipr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

public class CreateSectionDTO {

    @JsonFormat(pattern = "yyyy/MM/dd")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date sectionDateEnd;
    private String priority;
    private String sectionDescription;

    private List<CreatePointDTO> points;

    public CreateSectionDTO() {}


    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public List<CreatePointDTO> getPoints() {
        return points;
    }

    public void setPoints(List<CreatePointDTO> points) {
        this.points = points;
    }

    public Date getSectionDateEnd() {
        return sectionDateEnd;
    }

    public void setSectionDateEnd(Date sectionDateEnd) {
        this.sectionDateEnd = sectionDateEnd;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
