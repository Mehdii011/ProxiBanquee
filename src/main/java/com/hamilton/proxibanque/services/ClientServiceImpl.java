package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.dao.ClientRepository;
import com.hamilton.proxibanque.exception.ClientIntrouvable;
import com.hamilton.proxibanque.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;


    @Override
    public List<Client> getAllclients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> clientById(Long id) throws ClientIntrouvable {
        Optional<Client> client =clientRepository.findById(id);
        if (client.isEmpty()) throw new ClientIntrouvable("Client introuvable!!");

        return Optional.of(client.get());
    }
}
