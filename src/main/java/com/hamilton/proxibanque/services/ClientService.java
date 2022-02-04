package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.exception.ClientIntrouvable;
import com.hamilton.proxibanque.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getAllclients();
    Optional<Client> clientById(Long id) throws ClientIntrouvable;
    Client createclient(Client client) ;
    void editclient(Client client) ;
    void destroyclient(Long id) ;
}
