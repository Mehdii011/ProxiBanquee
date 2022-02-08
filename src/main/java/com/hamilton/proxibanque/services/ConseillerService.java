package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.exception.EmailExistException;
import com.hamilton.proxibanque.model.Conseiller;
import com.hamilton.proxibanque.model.Employe;

public interface ConseillerService {

    public Conseiller createConseiller(Conseiller conseiller) throws EmailExistException;

    Conseiller getConseillerById(Long id);
    Conseiller getConseillerByEmail(String email);

    Employe deleteById(Long id);

    Conseiller update(Conseiller newConseiller);

    void affectationConseillerClient(Long conseiller_id, Long client_id);

    Iterable<Employe> getAllConseillers();
}
