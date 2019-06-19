package ru.raiffeisen.ipr.mappers;

import org.modelmapper.ModelMapper;
import ru.raiffeisen.ipr.dto.*;
import ru.raiffeisen.ipr.entity.Client;

public class ClientMapper {
    public  static ModelMapper modelMapper = new ModelMapper();

    public static Client fromClientUpdateDTOToClientEntity(ClientUpdateDTO clientUpdateDTO) {
        return  modelMapper.map(clientUpdateDTO, Client.class);
    }

    public static Client fromClientDTOToClientEntity(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }

    public static ClientDTOAfterSave fromClientToClientDTOAfterSave(Client client) {
        return modelMapper.map(client, ClientDTOAfterSave.class);
    }
}
