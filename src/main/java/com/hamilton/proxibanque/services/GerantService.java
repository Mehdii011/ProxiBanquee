package com.hamilton.proxibanque.services;

import com.hamilton.proxibanque.exception.EmailExistException;
import com.hamilton.proxibanque.model.Gerant;

public interface GerantService {
    public Gerant createGerant(Gerant gerant) throws EmailExistException;

    public Gerant getGerantById(Long id);
    public Gerant getGerantByEmail(String email);
}
