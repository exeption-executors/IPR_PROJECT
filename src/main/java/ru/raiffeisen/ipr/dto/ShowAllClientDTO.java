package ru.raiffeisen.ipr.dto;

import ru.raiffeisen.ipr.entity.Client;

import java.util.List;

public class ShowAllClientDTO {

    private List<ShowAllClientDTO> clientList;

    public ShowAllClientDTO() {
    }

    public List<ShowAllClientDTO> getClientList() {
        return clientList;
    }

    public void setClientList(List<ShowAllClientDTO> clientList) {
        this.clientList = clientList;
    }
}
