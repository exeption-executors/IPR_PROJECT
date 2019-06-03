package ru.raiffeisen.ipr.mappers;

import org.modelmapper.ModelMapper;
import ru.raiffeisen.ipr.dto.ClientDTO;
import ru.raiffeisen.ipr.entity.Client;

public class ClientMapper {
    public  static ModelMapper modelMapper = new ModelMapper();

    public static Client fromClientDTOToClientEntity(ClientDTO clientDTO) {
        return  modelMapper.map(clientDTO, Client.class);
    }

    public static ClientDTO fromClientEntityToClientDTO(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }
}
