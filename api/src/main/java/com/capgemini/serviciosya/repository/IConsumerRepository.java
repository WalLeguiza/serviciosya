package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsumerRepository extends JpaRepository<ConsumerEntity, Integer> {

}
