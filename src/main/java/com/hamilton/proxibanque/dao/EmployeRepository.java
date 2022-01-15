package com.hamilton.proxibanque.dao;

import com.hamilton.proxibanque.model.Employe;
import org.springframework.data.repository.CrudRepository;

public interface EmployeRepository extends CrudRepository<Employe, Long> {
}
