package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.exception.CompteIntrouvable;
import com.hamilton.proxibanque.exception.DebitImpossibleException;
import com.hamilton.proxibanque.model.Compte;
import com.hamilton.proxibanque.model.Operation;

import java.util.List;
import java.util.Optional;

public interface IBanqueService {
    List<Compte> listeCompte(int page,int limit);
    Optional<Compte> consulterCompte(Long numCompte) throws CompteIntrouvable;
    void crediter(Long numCompte,double montant) throws CompteIntrouvable;
    void debiter(Long numCompte,double montant) throws DebitImpossibleException, CompteIntrouvable;
    void virement(Long numCompte1,Long numCompte2,double montant) throws DebitImpossibleException, CompteIntrouvable;
    List<Operation> operations(Long numCompte, int page, int size);




}
