package com.hamilton.proxibanque;

import com.hamilton.proxibanque.model.*;
import com.hamilton.proxibanque.dao.ClientRepository;
import com.hamilton.proxibanque.dao.CompteRepository;
import com.hamilton.proxibanque.dao.OperationRepository;
import com.hamilton.proxibanque.services.IBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ProxibanqueApplication implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private IBanqueService iBanqueService;

    public static void main(String[] args) {
        SpringApplication.run(ProxibanqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Client client1 = clientRepository.save(new Client(null, "Kaddouri", "ismail", "rabat", 11111, "rabat", "062444435"));
        Client client2 = clientRepository.save(new Client(null, "ProxiBanque", "Hamilton", "Casa", 15467, "Casablanca", "062626536"));
        Compte compteCourant = compteRepository.save(new CompteCourant("NumCompte1", 5000.29, new Date(), client1, 300));
        Compte compteEpargne = compteRepository.save(new CompteEpargne("NumCompte2", 1000, new Date(), client2, 5));
        operationRepository.save(new Versement(null, new Date(), 4000, compteCourant));
        operationRepository.save(new Versement(null, new Date(), 5000, compteCourant));
        operationRepository.save(new Retrait(null, new Date(), 5000, compteCourant));

        operationRepository.save(new Versement(null, new Date(), 3000, compteEpargne));
        operationRepository.save(new Versement(null, new Date(), 5000, compteEpargne));
        operationRepository.save(new Retrait(null, new Date(), 5000, compteEpargne));
        iBanqueService.crediter("NumCompte1", 6000);
        iBanqueService.crediter("NumCompte1", 400);

    }
}
