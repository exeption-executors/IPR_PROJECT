package ru.raiffeisen.ipr.rest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import ru.raiffeisen.ipr.dto.*;
import ru.raiffeisen.ipr.entity.Client;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.ipr.mappers.ClientMapper;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.exeption.ClientNotFoundException;
import ru.raiffeisen.ipr.service.exeption.ExistClientException;
import ru.raiffeisen.ipr.service.exeption.SectionNotFoundException;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    AmqpTemplate template;

    @Autowired
    private ClientService clientService;

    /**
     * ------ADD NEW CLIENT OPERATION-------
     **/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTOAfterSave createClient(@Valid @RequestBody ClientDTO clientDTO) {
        Client client = ClientMapper.fromClientDTOToClientEntity(clientDTO);
        clientService.saveClient(client);

        // Sending email to the queue with further sending to gmail smtp server
//        template.convertAndSend("clients", client.getEmail());
        return ClientMapper.fromClientToClientDTOAfterSave(client);
    }

    /**
     * ------DELETE CLIENT BY EMAIL-------
     **/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@RequestBody ClientDeleteByEmailDTO clientDeleteByEmailDTO) {
        clientService.deleteClientByEmail(clientDeleteByEmailDTO.getEmail());
    }

    /**
     * ------UPDATE CLIENT BY ID------
     **/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void updateClient(@RequestBody ClientUpdateDTO clientUpdateDTO) {
        Client clientForSave = ClientMapper.fromClientUpdateDTOToClientEntity(clientUpdateDTO);
        clientService.updateClient(clientForSave);
    }

//    @CrossOrigin(origins = "*")
//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public List<ClientDTO> getClients() {
//        List<Client> all = clientService.getAll();
//        return all.stream().map(client -> new ClientDTO(
//                client.getName(),
//                client.getSurname(),
//                client.getEmail(),
//                client.isFired(),
//                client.getPassword(),
//                client.getPartners().stream()
//                        .map(partner -> new PartnerDTO(partner.getSupport().stream().findFirst().get().getName(), partner.getRequirements()))
//                        .collect(Collectors.toList())))
//                .collect(Collectors.toList());
//    }
}
