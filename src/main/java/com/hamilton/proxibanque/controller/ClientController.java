package com.hamilton.proxibanque.controller;

import com.hamilton.proxibanque.dao.ClientRepository;
import com.hamilton.proxibanque.exception.ClientIntrouvable;
import com.hamilton.proxibanque.model.Client;
import com.hamilton.proxibanque.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientService.getAllclients();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable(value = "id")Long clientId)throws ClientIntrouvable {
        Optional<Client> client=clientService.clientById(clientId);
        return ResponseEntity.ok().body(client);
    }

}
