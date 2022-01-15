package com.hamilton.proxibanque.dao;

import com.hamilton.proxibanque.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
}
