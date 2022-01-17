package com.hamilton.proxibanque.controller;

import com.hamilton.proxibanque.dao.CompteRepository;
import com.hamilton.proxibanque.model.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@RestController
public class CompteController {
    @Autowired
    private CompteRepository compteRepository;

    @GetMapping("/comptes")
    public List<Compte> getAllComptes(){
        return compteRepository.findAll();
    }

    @GetMapping("/comptes/{numCompte}")
    public ResponseEntity<Compte> getCompteById(@PathVariable(value = "numCompte")Long compteId)
            throws ConfigDataResourceNotFoundException {
        Compte compte=compteRepository.findById(compteId).orElseThrow(()->new EntityNotFoundException("Compte n'existe pas pour cet id ::" +compteId));
        return ResponseEntity.ok().body(compte);
    }
}
