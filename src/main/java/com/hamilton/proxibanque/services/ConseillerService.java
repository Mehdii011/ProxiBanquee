package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.exception.EmailExistException;
import com.hamilton.proxibanque.model.Conseiller;
import com.hamilton.proxibanque.model.Employe;

public interface ConseillerService {

    public Conseiller createConseiller(Conseiller conseiller) throws EmailExistException;

    Conseiller getConseillerById(Long id);
    Conseiller getConseillerByEmail(String email);

    Iterable<Employe> getAllConseillers();
}
