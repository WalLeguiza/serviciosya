package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *  <p>The interface <code>com.capgemini.serviciosya.repository.ICountryRepository<code/>
 *  is a dao object for manipulate the countries information in the database.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@Repository
public interface ICountryRepository extends JpaRepository <CountryEntity, Integer> {

}
