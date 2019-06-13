package ru.raiffeisen.ipr.mappers;

import org.modelmapper.ModelMapper;
import ru.raiffeisen.ipr.dto.ClientDTO;
import ru.raiffeisen.ipr.dto.ClientUpdateDTO;
import ru.raiffeisen.ipr.dto.ClientDeleteByEmailDTO;
import ru.raiffeisen.ipr.dto.ShowAllClientDTO;
import ru.raiffeisen.ipr.entity.Client;

public class ClientMapper {
    public  static ModelMapper modelMapper = new ModelMapper();

    public static Client fromClientUpdateDTOToClientEntity(ClientUpdateDTO clientUpdateDTO) {
        return  modelMapper.map(clientUpdateDTO, Client.class);
    }

    public static Client fromClientDTOToClientEntity(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }

    public  static  ClientDeleteByEmailDTO deleteByEmailDTO(Client client) {
        return modelMapper.map(client, ClientDeleteByEmailDTO.class);
    }
    public static ShowAllClientDTO showAllClientDTO(Client client) {
        return modelMapper.map(client, ShowAllClientDTO.class);
    }
}
