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

    @Override
    public Compte update(Compte newCompte, Long numeroCompte) {
       Compte compte= compteRepository.findCompteByNumeroCompte(numeroCompte);
       compte.setNumeroCompte(newCompte.getNumeroCompte());
       compte.setSolde(newCompte.getSolde());
       compte.setClient(newCompte.getClient());
       return compteRepository.save(compte);
    }
    @Override
    public void editcomptecourant(CompteCourant compte) {
          Long id1=compte.getNumeroCompte();
       CompteCourant compte1=(CompteCourant) compteRepository.findCompteByNumeroCompte(id1);
        compte1.setNumeroCompte(compte.getNumeroCompte());
        compte1.setSolde(compte.getSolde());
        compte1.setDateCreation(compte.getDateCreation());
        compte1.setDecouvert(compte.getDecouvert());
        compteRepository.save(compte1);
        log.info("compte saved  with success {}", compte.getNumeroCompte());
    }
    @Override
    public void editcompteEpargne(CompteEpargne compte) {
        Long id1=compte.getNumeroCompte();
        CompteEpargne compte1=(CompteEpargne) compteRepository.findCompteByNumeroCompte(id1);
        compte1.setNumeroCompte(compte.getNumeroCompte());
        compte1.setSolde(compte.getSolde());
        compte1.setDateCreation(compte.getDateCreation());
        compte1.setTaux(compte.getTaux());
        compteRepository.save(compte1);
        log.info("compte saved  with success {}", compte.getNumeroCompte());
    }


}
