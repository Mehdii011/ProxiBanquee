package com.hamilton.proxibanque.dao;

import com.hamilton.proxibanque.model.Compte;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompteRepository extends PagingAndSortingRepository<Compte,Long> {

}
