package ru.raiffeisen.ipr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.raiffeisen.ipr.dto.ClientDTO;
import ru.raiffeisen.ipr.entity.Client;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.ipr.mappers.ClientMapper;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.impl.ClientServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Client> list(){
        return clientService.getAll();
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createClient(@RequestBody ClientDTO clientDTO) {
        Client client = ClientMapper.fromClientDTOToClientEntity(clientDTO);
        clientService.insertClient(client.getName(), client.getSurname(), client.getEmail(),false);
        System.out.println(client.getName());
        System.out.println(client.getSurname());
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createPost2(@RequestBody ClientDTO clientDTO) {
        Client client = ClientMapper.fromClientDTOToClientEntity(clientDTO);
        System.out.println(client.getName());
        System.out.println(client.getSurname());
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@RequestBody Client client){
        ClientDTO clientDTO = ClientMapper.fromClientEntityToClientDTO(client);
        clientService.deleteClientByEmail(clientDTO.getEmail());
    }

}
