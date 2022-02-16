package com.hamilton.proxibanque;

import com.hamilton.proxibanque.dao.EmployeRepository;
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
import java.util.function.Consumer;

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
    /*    Client client1 = clientRepository.save(new Client(null, "Mehdi", "Lakhlifi", "casablanca", 11111, "rabat", "062444435"));
        Client client2 = clientRepository.save(new Client(null, "ProxiBanque", "Hamilton", "Casa", 15467, "Casablanca", "062626536"));
        Client client3 = clientRepository.save(new Client(null, "Kaddouri", "ismail", "rabat", 11111, "rabat", "062444435"));

        Compte compteCourant1 = compteRepository.save(new CompteCourant(55555L, 5000.29, new Date(), client1, 300));
        Compte compteCourant2 = compteRepository.save(new CompteCourant(12587L, 5000.29, new Date(), client2, 300));
        Compte compteCourant3 = compteRepository.save(new CompteCourant(12254L, 5000.29, new Date(), client3, 300));
        Compte compteEpargne1 = compteRepository.save(new CompteEpargne(55554L, 5000.29, new Date(), client1, 300));
        Compte compteEpargne2 = compteRepository.save(new CompteEpargne(12577L, 5000.29, new Date(), client2, 300));
        Compte compteEpargne3 = compteRepository.save(new CompteEpargne(12454L, 5000.29, new Date(), client3, 300));




        operationRepository.save(new Versement(null, new Date(), 4000, compteCourant1));
        operationRepository.save(new Versement(null, new Date(), 5000, compteCourant2));
        operationRepository.save(new Retrait(null, new Date(), 5000, compteCourant3));

        operationRepository.save(new Versement(null, new Date(), 3000, compteEpargne1));
        operationRepository.save(new Versement(null, new Date(), 5000, compteEpargne2));
        operationRepository.save(new Retrait(null, new Date(), 5000, compteEpargne3));
        iBanqueService.crediter(55555L, 6000);
        iBanqueService.crediter(55555L, 400);*/

    }
}
