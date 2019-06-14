package ru.raiffeisen.ipr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import ru.raiffeisen.ipr.dto.ClientDTO;
import ru.raiffeisen.ipr.dto.ClientUpdateDTO;
import ru.raiffeisen.ipr.dto.ClientDeleteByEmailDTO;
import ru.raiffeisen.ipr.dto.ShowAllClientDTO;
import ru.raiffeisen.ipr.entity.Client;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.ipr.mappers.ClientMapper;
import ru.raiffeisen.ipr.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ShowAllClientDTO> list(){
        List showAllClientDTO = clientService.getAll();
        return showAllClientDTO;
    }

/**------ADD NEW CLIENT OPERATION-------**/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody ClientDTO clientDTO) {
        Client client = ClientMapper.fromClientDTOToClientEntity(clientDTO);
        clientService.saveClient(client);
    }

/**------DELETE CLIENT BY EMAIL-------**/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@RequestBody Client client){
        ClientDeleteByEmailDTO clientDeleteByEmailDTO = ClientMapper.deleteByEmailDTO(client);
        clientService.deleteClientByEmail(clientDeleteByEmailDTO.getEmail());
    }
/**------UPDATE CLIENT BY ID------**/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void updateClient(@RequestBody ClientUpdateDTO clientUpdateDTO) {
        Client clientForSave = ClientMapper.fromClientUpdateDTOToClientEntity(clientUpdateDTO);
        clientService.saveClient(clientForSave);
    }
}
