package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.dao.CompteRepository;
import com.hamilton.proxibanque.model.Compte;
import com.hamilton.proxibanque.model.CompteCourant;
import com.hamilton.proxibanque.model.CompteEpargne;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class CompteServiceImpl implements ICompteService{

    @Autowired
    private CompteRepository compteRepository;


    @Override
    public Compte createcompteCourant(CompteCourant compte) {
      return  compteRepository.save(compte);
      //  log.info("compte saved  with success {}", compte.getNumeroCompte());
    }
    @Override
    public Compte createcompteEpargne(CompteEpargne compte) {
       return compteRepository.save(compte);
       //log.info("compte saved  with success {}", compte.getNumeroCompte());
    }

    @Override
    public void editcompte(Compte compte) {
        compteRepository.save(compte);
        log.info("compte saved  with success {}", compte.getNumeroCompte());
    }



    @Override
    public void destroycompte(Long numCompte) {
        compteRepository.deleteById(numCompte);
        log.info("compte deleted with success {}", numCompte);
    }


}
