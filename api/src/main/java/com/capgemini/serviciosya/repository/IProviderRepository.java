package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.OccupationEntity;
import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *  <p>The interface <code>com.capgemini.serviciosya.repository.IProviderRepository<code/>
 *  is a dao object for manipulate the providers information in the database.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@Repository
public interface IProviderRepository extends JpaRepository <ProviderEntity, Integer> {

    /**
     *
     *  <p>Return the providers searches by city.
     *
     *  @return Return the provider list.
     * */
    List<ProviderEntity> findAllByCity (CityEntity city);

    /**
     *
     *  <p>Return the provider search by email.
     *
     *  @return Return a provider.
     * */
    ProviderEntity findByEmail (String email);

    /**
     *
     *  <p>Return the providers searches by occupation.
     *
     *  @return Return the provider list.
     * */
    List<ProviderEntity> findAllByOccupations (OccupationEntity occupation);
}
