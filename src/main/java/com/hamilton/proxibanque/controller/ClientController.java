package com.hamilton.proxibanque.controller;

import com.hamilton.proxibanque.dao.ClientRepository;
import com.hamilton.proxibanque.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id")Long clientId)
            throws ConfigDataResourceNotFoundException {
        Client client=clientRepository.findById(clientId).orElseThrow(()->new EntityNotFoundException("Client n'existe pas pour cet id :" +clientId));
        return ResponseEntity.ok().body(client);
    }

}
