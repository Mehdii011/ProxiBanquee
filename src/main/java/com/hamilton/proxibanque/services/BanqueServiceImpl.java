package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.dao.CompteRepository;
import com.hamilton.proxibanque.dao.OperationRepository;
import com.hamilton.proxibanque.exception.CompteIntrouvable;
import com.hamilton.proxibanque.exception.DebitImpossibleException;
import com.hamilton.proxibanque.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BanqueServiceImpl implements IBanqueService {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Optional<Compte> consulterCompte(Long numCompte) throws CompteIntrouvable {
        Optional<Compte> compte = compteRepository.findById(numCompte);
        if (compte.isEmpty()) throw new CompteIntrouvable("Compte introuvable!!");
        return Optional.of(compte.get());
    }

    @Override
    public void crediter(Long numCompte, double montant) throws CompteIntrouvable {
        Optional<Compte> compte = consulterCompte(numCompte);
        Versement versement = new Versement(null, new Date(), montant, compte.get());
        operationRepository.save(versement);
        compte.get().setSolde(compte.get().getSolde() + montant);
        compteRepository.save(compte.get());

    }

    @Override
    public void debiter(Long numCompte, double montant) throws DebitImpossibleException, CompteIntrouvable {
        Optional<Compte> compte = consulterCompte(numCompte);
        double creditCaisse = 0;
        if (compte.get() instanceof CompteCourant) creditCaisse = ((CompteCourant) compte.get()).getDecouvert();
        if (compte.get().getSolde() + creditCaisse < montant)
            throw new DebitImpossibleException("Impossbile de traiter cette opération : Solde insuffisant");
        Retrait retrait = new Retrait(null, new Date(), montant, compte.get());
        operationRepository.save(retrait);
        compte.get().setSolde(compte.get().getSolde() - montant);
        compteRepository.save(compte.get());
    }

    @Override
    public void virement(Long numCompte1, Long numCompte2, double montant) throws DebitImpossibleException, CompteIntrouvable {
        debiter(numCompte1, montant);
        crediter(numCompte2, montant);

    }

    @Override
    public Page<Operation> operations(Long numCompte, int page, int size) {

        return operationRepository.operations(numCompte, PageRequest.of(page, size));
    }

    @Override
    public List<Compte> listeCompte() {
        return compteRepository.findAll();
    }


}
