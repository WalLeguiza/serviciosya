package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *  <p>The interface <code>com.capgemini.serviciosya.repository.IConsumerRepository<code/>
 *  is a dao object for manipulate the consumers information in the database.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@Repository
public interface IConsumerRepository extends JpaRepository<ConsumerEntity, Integer> {

}
