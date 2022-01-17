package com.hamilton.proxibanque.controller;

import com.hamilton.proxibanque.model.Employe;
import com.hamilton.proxibanque.model.Gerant;
import com.hamilton.proxibanque.services.GerantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GerantController {
    @Autowired
    private GerantService gerantService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @PostMapping("Employe/createGerant")
    public ResponseEntity<?> createConseiller(@Valid @RequestBody Gerant gerant){
//        conseiller.setPassword(passwordEncoder.encode(conseiller.getPassword()));
        try{
            gerantService.createGerant(gerant);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(gerant, HttpStatus.OK);
    }

    @GetMapping("/Employe/gerant/{id}")
    public ResponseEntity<?> getGerantById(@PathVariable Long id){
        Gerant gerant = gerantService.getGerantById(id);
        return new ResponseEntity<>(gerant, HttpStatus.OK);
    }
    @GetMapping("/Employe/gerant/email/{email}")
    public ResponseEntity<?> getConseillerByEmail(@PathVariable String email){
        Gerant gerant = gerantService.getGerantByEmail(email);
        return new ResponseEntity<>(gerant, HttpStatus.OK);
    }

}
