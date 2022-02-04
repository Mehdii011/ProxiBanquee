package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.exception.CompteIntrouvable;
import com.hamilton.proxibanque.exception.DebitImpossibleException;
import com.hamilton.proxibanque.model.Compte;
import com.hamilton.proxibanque.model.Operation;
import com.hamilton.proxibanque.model.Retrait;
import com.hamilton.proxibanque.model.Versement;

import java.util.List;
import java.util.Optional;

public interface IBanqueService {
    List<Compte> listeCompte(int page,int limit);
    Optional<Compte> consulterCompte(Long numCompte) throws CompteIntrouvable;
    Versement crediter(Long numCompte, double montant) throws CompteIntrouvable;
    Retrait debiter(Long numCompte, double montant) throws DebitImpossibleException, CompteIntrouvable;
    void virement(Long numCompte1,Long numCompte2,double montant) throws DebitImpossibleException, CompteIntrouvable;
    List<Operation> operations(int page, int limit);
    List<Operation> operationsByCompte(Long numCompte,int page, int limit);



}
