package com.hamilton.proxibanque.controller;

import com.hamilton.proxibanque.model.Conseiller;
import com.hamilton.proxibanque.model.Employe;
import com.hamilton.proxibanque.services.ConseillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class ConseillerController {

    @Autowired
    private ConseillerService conseillerService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @PostMapping("/Employe/createConseiller")
    public ResponseEntity<?> createConseiller(@Valid @RequestBody Conseiller conseiller){
//        conseiller.setPassword(passwordEncoder.encode(conseiller.getPassword()));
        try{
            conseillerService.createConseiller(conseiller);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(conseiller, HttpStatus.OK);
    }

    @GetMapping("/Employe/conseillerById/{id}")
    public ResponseEntity<?> getConseillerById(@PathVariable Long id){
        Conseiller conseiller = conseillerService.getConseillerById(id);
        return new ResponseEntity<>(conseiller, HttpStatus.OK);
    }
    @GetMapping("/Employe/conseiller/{email}")
    public ResponseEntity<?> getConseillerByEmail(@PathVariable String email){
        Conseiller conseiller = conseillerService.getConseillerByEmail(email);
        return new ResponseEntity<>(conseiller, HttpStatus.OK);
    }

    @GetMapping("/Employe/conseillers")
    public Iterable<Employe> getAllConseillers(){
        Iterable<Employe> conseillers = conseillerService.getAllConseillers();
        return conseillers;
    }

}
