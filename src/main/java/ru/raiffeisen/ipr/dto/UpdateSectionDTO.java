package ru.raiffeisen.ipr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.sql.Date;

public class UpdateSectionDTO {
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date sectionDateEnd;
    private String sectionDescription;
    private String priority;

    @Id
    private Long id;

    public UpdateSectionDTO() {}

    public Date getSectionDateEnd() {
        return sectionDateEnd;
    }

    public void setSectionDateEnd(Date sectionDateEnd) {
        this.sectionDateEnd = sectionDateEnd;
    }

    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
