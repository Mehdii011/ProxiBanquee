package com.hamilton.proxibanque.dao;

import com.hamilton.proxibanque.model.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends CrudRepository<Operation,Long> {
@Query("select Op from Operation Op where Op.compte.numeroCompte=:cp order by Op.dateOperation desc ")
    Page<Operation> operations(@Param("cp") Long numCompte, Pageable pageable);
}
