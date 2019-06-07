package ru.raiffeisen.ipr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import ru.raiffeisen.ipr.dto.ClientDTO;
import ru.raiffeisen.ipr.dto.ClientDeleteByEmailDTO;
import ru.raiffeisen.ipr.dto.ShowAllClientDTO;
import ru.raiffeisen.ipr.entity.Client;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.ipr.mappers.ClientMapper;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.impl.ClientServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ShowAllClientDTO> list(){
        List showAllClientDTO = clientService.getAll();
        return showAllClientDTO;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody ClientDTO clientDTO) {
        Client client = ClientMapper.fromClientDTOToClientEntity(clientDTO);
        clientService.saveClient(client);
        System.out.println(client.getName());
        System.out.println(client.getSurname());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@RequestBody Client client){
        ClientDeleteByEmailDTO clientDeleteByEmailDTO1 = ClientMapper.deleteByEmailDTO(client);
        clientService.deleteClientByEmail(clientDeleteByEmailDTO1.getEmail());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void updateClient(@RequestBody Client client) {
        ClientDTO clientDTO1 = ClientMapper.fromClientEntityToClientDTO(client);
        clientService.findByEmail(clientDTO1.getEmail());
        Client client1 = ClientMapper.fromClientDTOToClientEntity(clientDTO1);
        clientService.saveClient(client1);
    }
}
