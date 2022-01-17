package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.dao.EmployeRepository;
import com.hamilton.proxibanque.exception.EmailExistException;
import com.hamilton.proxibanque.model.Conseiller;
import com.hamilton.proxibanque.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConseillerServiceImpl implements ConseillerService {
    @Autowired
    private EmployeRepository conseillerRepo;

    @Override
    public Conseiller createConseiller(Conseiller conseiller) throws EmailExistException{
        if (conseillerRepo.findByEmail(conseiller.getEmail())!= null)
            throw new EmailExistException("Conseiller Existe déjà !!");
        return conseillerRepo.save(conseiller);
    }

    @Override
    public Conseiller getConseillerById(Long id) {
        Optional<Employe> conseiller = conseillerRepo.findById(id);
        return (Conseiller) conseiller.orElse(null);
    }

    @Override
    public Conseiller getConseillerByEmail(String email) {
        Conseiller conseiller = (Conseiller) conseillerRepo.findByEmail(email);
        if (conseiller == null) return  null;
        return conseiller;
    }

    @Override
    public Iterable<Employe> getAllConseillers() {
        return conseillerRepo.findAll();
    }
}
