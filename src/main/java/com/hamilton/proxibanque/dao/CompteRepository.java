package com.hamilton.proxibanque.dao;

import com.hamilton.proxibanque.model.Compte;
import org.springframework.data.repository.CrudRepository;

public interface CompteRepository extends CrudRepository<Compte,String> {
}
