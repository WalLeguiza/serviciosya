package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *  <p>The interface <code>com.capgemini.serviciosya.repository.ICityRepository<code/>
 *  is a dao object for manipulate the cities information in the database.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@Repository
public interface ICityRepository extends JpaRepository<CityEntity, Integer> {

    /**
     *
     *  <p>Return the providers searches by occupation.
     *
     *  @return Return the provider list.
     * */
    List<CityEntity> findAllByProvince (ProvinceEntity province);

    /**
     *
     *  <p>Return the city search by name.
     *
     *  @return Return a city.
     * */
    CityEntity findByName (String val);
}
