package com.hamilton.proxibanque.controller;

import com.hamilton.proxibanque.dao.CompteRepository;
import com.hamilton.proxibanque.exception.CompteIntrouvable;
import com.hamilton.proxibanque.exception.DebitImpossibleException;
import com.hamilton.proxibanque.model.Compte;
import com.hamilton.proxibanque.model.Operation;
import com.hamilton.proxibanque.services.IBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;
import java.util.List;
import java.util.Optional;

@RestController
public class CompteController {

    @Autowired
    private IBanqueService iBanqueService;

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
    public ResponseEntity<Operation> saveVersement(@RequestBody Operation operation) throws CompteIntrouvable {
        iBanqueService.crediter(operation.getCompte().getNumeroCompte(), operation.getMontant());

        return ResponseEntity.ok(operation);
    }

    @PostMapping("/saveRetrait")
    public ResponseEntity<Operation> saveRetrait(@RequestBody Operation operation) throws CompteIntrouvable, DebitImpossibleException {
        iBanqueService.debiter(operation.getCompte().getNumeroCompte(), operation.getMontant());
        return ResponseEntity.ok(operation);
    }

    @PostMapping("/saveVirement")
    public ResponseEntity<Operation> saveVirement(@RequestBody Operation operation, @RequestBody Long numCompte2) throws CompteIntrouvable, DebitImpossibleException {
        try {
            Optional<Compte> compte = iBanqueService.consulterCompte(numCompte2);
            if (compte.isEmpty()) {
                throw new CompteIntrouvable("Transaction Impossible : Compte bénéficiaire n'existe pas");
            }
            iBanqueService.virement(operation.getCompte().getNumeroCompte(), numCompte2, operation.getMontant());

            return ResponseEntity.ok(operation);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

}

