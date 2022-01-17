package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.dao.EmployeRepository;
import com.hamilton.proxibanque.exception.EmailExistException;
import com.hamilton.proxibanque.model.Conseiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ConseillerService {

    public Conseiller createConseiller(Conseiller conseiller) throws EmailExistException;

    Conseiller getConseillerById(Long id);
}
