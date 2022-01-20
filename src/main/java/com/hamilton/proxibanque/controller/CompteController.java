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

import java.util.List;
import java.util.Optional;

@RestController
public class CompteController {

    @Autowired
    private IBanqueService iBanqueService;

    @GetMapping("/listcomptes")
    public ResponseEntity<List<Compte>> listeCompte(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit",defaultValue = "5") int limit) {
        List<Compte> comptes = iBanqueService.listeCompte(page, limit);
        return new ResponseEntity<>(comptes, HttpStatus.OK);
    }

    @GetMapping("/comptes/{numCompte}")
    public ResponseEntity<Compte> getCompteById(@PathVariable(value = "numCompte") Long compteId) throws CompteIntrouvable {
        Optional<Compte> compte = iBanqueService.consulterCompte(compteId);
        return ResponseEntity.ok().body(compte.isPresent() ? compte.get() : null);
    }
    @GetMapping("/listoperations/{numCompte}")
    public ResponseEntity<List<Operation>> listeOperation(@PathVariable(value = "numCompte") Long compteId,@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit",defaultValue = "5") int limit) {
        List<Operation> operations = iBanqueService.operations(compteId,page, limit);
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }
    @PostMapping("/saveOperation")
    public ResponseEntity<Operation> saveOperation(@RequestBody Operation operation,@RequestParam(value = "typeOperation") String typeOperation,Long numCompte2) throws CompteIntrouvable, DebitImpossibleException {
        if(typeOperation.equals("Versement")){
            iBanqueService.crediter(operation.getCompte().getNumeroCompte(),operation.getMontant());}
        else if(typeOperation.equals("Retrait")){
            iBanqueService.debiter(operation.getCompte().getNumeroCompte(),operation.getMontant());
        }
        if(typeOperation.equals("Virement")){
            iBanqueService.virement(operation.getCompte().getNumeroCompte(),numCompte2,operation.getMontant());
        }
        return ResponseEntity.ok(operation);
    }
    }

