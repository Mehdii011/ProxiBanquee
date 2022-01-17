package com.hamilton.proxibanque.controller;

import com.hamilton.proxibanque.dao.CompteRepository;
import com.hamilton.proxibanque.exception.CompteIntrouvable;
import com.hamilton.proxibanque.model.Compte;
import com.hamilton.proxibanque.services.IBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
public class CompteController {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private IBanqueService iBanqueService;

    @GetMapping("/comptes")
    public List<Compte> getAllComptes(){
        return iBanqueService.listeCompte();
    }


    @GetMapping("/comptes/{numCompte}")
    public ResponseEntity<Optional<Compte>> getCompteById(@PathVariable(value = "numCompte")Long compteId) throws CompteIntrouvable {
        Optional<Compte> compte=iBanqueService.consulterCompte(compteId);
        return ResponseEntity.ok().body(compte);
    }

}
