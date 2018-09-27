package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *  <p>The interface <code>com.capgemini.serviciosya.repository.IContractRepository<code/>
 *  is a dao object for manipulate the contracts information in the database.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@Repository
public interface IContractRepository extends JpaRepository<ContractEntity, Integer> {

}
