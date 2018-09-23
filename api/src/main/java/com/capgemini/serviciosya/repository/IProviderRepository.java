package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.OccupationEntity;
import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProviderRepository extends JpaRepository <ProviderEntity, Integer> {

    List<ProviderEntity> findAllByCity (CityEntity city);
    ProviderEntity findByEmail (String email);
    List<ProviderEntity> findAllByOccupations (OccupationEntity occupation);
}
