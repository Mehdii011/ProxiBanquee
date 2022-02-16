package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.model.Compte;
import com.hamilton.proxibanque.model.CompteCourant;
import com.hamilton.proxibanque.model.CompteEpargne;

import javax.transaction.Transactional;

@Transactional
public interface ICompteService {

    Compte createcompteCourant(CompteCourant compte) ;
    Compte createcompteEpargne(CompteEpargne compte) ;
    void editcompte(Compte compte) ;
    void destroycompte(Long numCompte) ;

    Compte update(Compte newCompte, Long numeroCompte);

    void editcomptecourant(CompteCourant compte);

    void editcompteEpargne(CompteEpargne compte);
}
