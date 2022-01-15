package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.exception.CompteIntrouvable;
import com.hamilton.proxibanque.exception.DebitImpossibleException;
import com.hamilton.proxibanque.model.Compte;
import com.hamilton.proxibanque.model.Operation;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IBanqueService {

    Optional<Compte> consulterCompte(String numCompte) throws CompteIntrouvable;
    void crediter(String numCompte,double montant) throws CompteIntrouvable;
    void debiter(String numCompte,double montant) throws DebitImpossibleException, CompteIntrouvable;
    void virement(String numCompte1,String numCompte2,double montant) throws DebitImpossibleException, CompteIntrouvable;
    Page<Operation> operations(String numCompte,int page, int size);

}
