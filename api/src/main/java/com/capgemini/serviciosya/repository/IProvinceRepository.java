package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *  <p>The interface <code>com.capgemini.serviciosya.repository.IProvinceRepository<code/>
 *  is a dao object for manipulate the provinces information in the database.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@Repository
public interface IProvinceRepository extends JpaRepository <ProvinceEntity, Integer> {

    /**
     *
     *  <p>Return the provinces searches by country and ordened by name.
     *
     *  @return Return the province list.
     * */
    List<ProvinceEntity> findAllByCountryOrderByName (CountryEntity country);
}
