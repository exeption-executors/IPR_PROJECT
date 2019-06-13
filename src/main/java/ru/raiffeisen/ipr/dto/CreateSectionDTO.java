package ru.raiffeisen.ipr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import ru.raiffeisen.ipr.entity.Point;

import java.sql.Date;
import java.util.List;

public class CreateSectionDTO {
    @JsonFormat(pattern = "yyyy/MM/dd")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date sectionDateEnd;
    private String priority;
    private String sectionDescription;

    private List<PointDTO> allIncludedPoint;

    public CreateSectionDTO() {}


    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public List<PointDTO> getAllIncludedPoint() {
        return allIncludedPoint;
    }

    public void setAllIncludedPoint(List<PointDTO> allIncludedPoint) {
        this.allIncludedPoint = allIncludedPoint;
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
