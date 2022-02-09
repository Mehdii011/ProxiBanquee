package com.hamilton.proxibanque.dao;

import com.hamilton.proxibanque.model.Compte;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompteRepository extends PagingAndSortingRepository<Compte,Long> {
  List<Compte> findAll();
  List<Compte> findByClientId(Long clientId);
}
