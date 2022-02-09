package com.hamilton.proxibanque.dao;

import com.hamilton.proxibanque.model.Conseiller;
import com.hamilton.proxibanque.model.Employe;
import com.hamilton.proxibanque.model.Gerant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Long> {
    Employe findByEmail(String email);
    List<Employe> findAll();
}
