package ru.raiffeisen.ipr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class PlanDTO {
    private Long client_id;
    @JsonFormat(pattern = "yyyy/MM/dd")
    // Allows dd/MM/yyyy date to be passed into GET request in JSON
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date plan_date_start;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date plan_date_end;

    public PlanDTO() {}

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Date getPlan_date_start() {
        return plan_date_start;
    }

    public void setPlan_date_start(Date plan_date_start) {
        this.plan_date_start = plan_date_start;
    }

    public Date getPlan_date_end() {
        return plan_date_end;
    }

    public void setPlan_date_end(Date plan_date_end) {
        this.plan_date_end = plan_date_end;
    }
}
