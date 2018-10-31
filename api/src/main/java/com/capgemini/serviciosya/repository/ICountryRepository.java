package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    CountryEntity findByName (String name);

    List<CountryEntity> findAllByIdBetween (Integer start, Integer end);

    List<CountryEntity> findAllByIdGreaterThan (Integer value);

    @Query ("FROM Country c WHERE c.id < :id")
    List<CountryEntity> findAllByIdIsLessThan (@Param ("id") Integer value);

    @Query (value = "SELECT * FROM country WHERE name LIKE ?A",
            nativeQuery = true)
    List<CountryEntity> findAllByName (String val);

}
