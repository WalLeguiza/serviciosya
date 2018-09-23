package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<ContractEntity, Integer> {

}
