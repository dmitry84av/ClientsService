package com.example.clientsservice.controllers.restcontrollers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.srvices.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientsRestController {

    @Qualifier("clientServiceDb")
    @Autowired
    private ClientService clientService;

    @PostMapping("/rest/addClientForm")
    public ResponseEntity<?> addClientForm(@RequestBody Client client) {
        System.err.println(client);
        clientService.save(client);
        List<Client> list = clientService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }
}
