package com.capgemini.serviciosya.rest.service;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.repository.ICityRepository;
import com.capgemini.serviciosya.repository.ICountryRepository;
import com.capgemini.serviciosya.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    private ICountryRepository countryRepository;

    @Autowired
    private IProvinceRepository provinceRepository;

    @Autowired
    private ICityRepository cityRepository;

    public ProvinceService () {

        super();
    }

    public ResponseEntity<?> getAll () {

        return ResponseEntity.ok(provinceRepository.findAll());
    }

    public ResponseEntity<ProvinceEntity> getId (Integer id) {

        ProvinceEntity province = provinceRepository.findOne(id);

        if (province == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok(province);
        }
    }

    public ResponseEntity<?> getAllByCountry (String nameCountry) {

        CountryEntity country = countryRepository.findByName(nameCountry);

        if (country == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok(provinceRepository.findAllByCountry(country));
        }
    }

    public ResponseEntity<?> add (ProvinceEntity province) {

        try {

            this.provinceRepository.save(province);

        } catch (Exception e) {

            return ResponseEntity.badRequest().build();

        }

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<?> update (ProvinceEntity province, Integer id) {

        ProvinceEntity p = provinceRepository.findOne(id);

        if (p == null) {

            return ResponseEntity.notFound().build();

        } else {

            try {

                p.setName(province.getName());
                p.setCountry(province.getCountry());
                this.provinceRepository.save (p);

            } catch (Exception e) {

                return ResponseEntity.unprocessableEntity ().build ();
            }

            return ResponseEntity.noContent().build ();
        }
    }

    public ResponseEntity<?> delete (Integer id) {

        ProvinceEntity province = provinceRepository.findOne(id);
        List<CityEntity> cities = cityRepository.findAllByProvince(province);

        if (province == null) {

            return ResponseEntity.notFound().build();

        }if (!cities.isEmpty()) {

            return ResponseEntity.status (HttpStatus.CONFLICT).body("Provincia referenciada por una o mas ciudades!");

        } else {

            provinceRepository.delete(id);
            return ResponseEntity.noContent().build();
        }
    }
}

