package com.hamilton.proxibanque.dao;

import com.hamilton.proxibanque.model.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation,Long> {
    @Query("select Op from Operation Op where Op.compte.numeroCompte=:cp order by Op.dateOperation desc ")
    Page<Operation> operationsByCompte(@Param("cp") Long numCompte, Pageable pageable);
}
