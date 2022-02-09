package com.hamilton.proxibanque.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hamilton.proxibanque.dao.CompteRepository;
import com.hamilton.proxibanque.dao.ClientRepository;
import com.hamilton.proxibanque.exception.CompteIntrouvable;
import com.hamilton.proxibanque.exception.DebitImpossibleException;
import com.hamilton.proxibanque.exception.AddCompteImpossible;
import com.hamilton.proxibanque.model.Compte;
import com.hamilton.proxibanque.model.Operation;
import com.hamilton.proxibanque.model.*;
import com.hamilton.proxibanque.services.IBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hamilton.proxibanque.services.ClientServiceImpl;
import com.hamilton.proxibanque.services.CompteServiceImpl;
import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeMap;
import java.net.http.HttpClient;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
public class CompteController {

    @Autowired
    private IBanqueService iBanqueService;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompteServiceImpl compteService;
    @Autowired
    private ClientServiceImpl clientService;
   
    @GetMapping("/listcomptes")
    public ResponseEntity<List<Compte>> listeCompte(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "5") int limit) {
        List<Compte> comptes = iBanqueService.listeCompte(page, limit);
        return new ResponseEntity<>(comptes, HttpStatus.OK);
    }

    @GetMapping("/comptes/{numCompte}")
    public ResponseEntity<Compte> getCompteById(@PathVariable(value = "numCompte") Long compteId) throws CompteIntrouvable {
        Optional<Compte> compte = iBanqueService.consulterCompte(compteId);
        return ResponseEntity.ok().body(compte.isPresent() ? compte.get() : null);
    }

    @GetMapping("/listoperations")
    public ResponseEntity<List<Operation>> listeOperations(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "5") int limit) {
        List<Operation> operations = iBanqueService.operations(page, limit);
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }

    @GetMapping("/listoperationsByCompte/{numCompte}")
    public ResponseEntity<List<Operation>> operationsBycompte(@PathVariable(value = "numCompte") Long compteId, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "5") int limit) {
        List<Operation> operations = iBanqueService.operationsByCompte(compteId, page, limit);
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }

    @PostMapping("/saveVersement")
    public ResponseEntity<Versement> saveVersement(@RequestBody ObjectNode jsonNodes) throws CompteIntrouvable {
        Long numCompte = jsonNodes.get("numeroCompte").asLong();
        double montant = jsonNodes.get("montant").asDouble();
        return ResponseEntity.ok(iBanqueService.crediter(numCompte, montant));

    }

    @PostMapping("/saveRetrait")
    public ResponseEntity<Retrait> saveRetrait(@RequestBody ObjectNode jsonNodes) throws CompteIntrouvable, DebitImpossibleException {
        Long numCompte = jsonNodes.get("numeroCompte").asLong();
        double montant = jsonNodes.get("montant").asDouble();

        return ResponseEntity.ok(iBanqueService.debiter(numCompte, montant));
    }

    @PostMapping(value = "/saveVirement")
    public  ResponseEntity saveVirement(@RequestBody ObjectNode jsonNodes) throws CompteIntrouvable, DebitImpossibleException {
        Long numCompte = jsonNodes.get("numeroCompte").asLong();
        Long numCompte2 = jsonNodes.get("numeroCompte2").asLong();
        double montant = jsonNodes.get("montant").asDouble();
        iBanqueService.consulterCompte(numCompte2);
        iBanqueService.virement(numCompte, numCompte2, montant);
        return ResponseEntity.ok(jsonNodes);


    }

     @PostMapping("/compteEpargne")
    public void createcompteEpargne(@RequestBody CompteEpargne compte,@RequestParam Long id) throws AddCompteImpossible {

        if(id != 0){
        Optional<Client> rep = clientRepository.findById(id);
            if (rep.isPresent() ) {
                if (rep.get().getComptes().size() < 2) {
                    Client client = rep.get();
                    compte.setClient(client);
                    ResponseEntity<CompteEpargne> ca = new ResponseEntity(compteService.createcompteEpargne(compte), HttpStatus.CREATED);
                }else{
                    log.info("ce client a deja deux compte",rep);
                    throw new AddCompteImpossible("vous avez déjà deux comptes!!");
                }
            }
        }else{
            if (compte.getClient().getComptes().size() < 2) {
                ResponseEntity<CompteEpargne> ca = new ResponseEntity(compteService.createcompteEpargne(compte), HttpStatus.CREATED);
            }else{
                throw new AddCompteImpossible("vous avez déjà deux comptes!!");
            }
        }

    }

      @PostMapping("/compteCourant")

    public void createcompteCourant(@RequestBody CompteCourant compte) throws AddCompteImpossible{

        Client client = compte.getClient();
       // return new ResponseEntity<>(compteService.createcompteCourant(compte), HttpStatus.CREATED);
        Optional<Client> rep = clientRepository.findById(client.getId());

        if(rep.isPresent()) {
            if (rep.get().getComptes().size() < 2) {
                ResponseEntity<CompteCourant> cc =new ResponseEntity(compteService.createcompteCourant(compte), HttpStatus.CREATED);
            } else {
                throw new AddCompteImpossible("vous avez déjà deux comptes!!");
            }
        }else{
            ResponseEntity<CompteCourant> cc =new ResponseEntity(compteService.createcompteCourant(compte), HttpStatus.CREATED);

        }
    }

}

