package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.dao.EmployeRepository;
import com.hamilton.proxibanque.exception.EmailExistException;
import com.hamilton.proxibanque.model.Employe;
import com.hamilton.proxibanque.model.Gerant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GerantServiceImpl implements GerantService{
    @Autowired
    private EmployeRepository gerantRepo;

    @Override
    public Gerant createGerant(Gerant gerant) throws EmailExistException {
        if (gerantRepo.findByEmail(gerant.getEmail())!= null)
            throw new EmailExistException("Gerant Existe déjà !!");
        return gerantRepo.save(gerant);
    }

    @Override
    public Gerant getGerantById(Long id) {
        Optional<Employe> conseiller = gerantRepo.findById(id);
        return (Gerant) conseiller.orElse(null);
    }

    @Override
    public Gerant getGerantByEmail(String email) {
        Gerant gerant = (Gerant) gerantRepo.findByEmail(email);
        if (gerant == null) return  null;
        return gerant;
    }
}
