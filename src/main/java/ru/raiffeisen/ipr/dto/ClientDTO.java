package ru.raiffeisen.ipr.dto;

import ru.raiffeisen.ipr.constraints.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class ClientDTO {
    @NotBlank
    @Size(min=2, max=18)
    private String name;

    @NotBlank
    @Size(min=2, max=18)
    private String surname;

    @Email()
    private String email;

    private boolean fired;

    @NotBlank
    @ValidPassword
    private String password;

    private List<PartnerDTO> partnerList;

    public ClientDTO() {
    }

    public ClientDTO(String name, String surname, String email, String password, boolean fired) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.fired = fired;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public List<PartnerDTO> getPartnerList() {
        return partnerList;
    }

    public void setPartnerList(List<PartnerDTO> partnerList) {
        this.partnerList = partnerList;
    }
}
