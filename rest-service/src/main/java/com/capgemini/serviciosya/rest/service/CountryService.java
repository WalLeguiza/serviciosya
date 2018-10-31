package com.capgemini.serviciosya.rest.service;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.repository.ICountryRepository;
import com.capgemini.serviciosya.repository.IProvinceRepository;
import com.capgemini.serviciosya.rest.client.CountryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private ICountryRepository countryRepository;

    @Autowired
    private IProvinceRepository provinceRepository;

    public CountryService () {

        super();
    }

    public ResponseEntity<?> getAll () {

        return ResponseEntity.ok(countryRepository.findAll());
    }

    public ResponseEntity<CountryEntity> getId (Integer id) {

        CountryEntity country = this.countryRepository.findOne (id);

        if (country == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok (country);
        }
    }

    public ResponseEntity<CountryEntity> getByName (String name) {

        CountryEntity country = this.countryRepository.findByName (name);

        if (country == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok(country);
        }
    }

    public ResponseEntity<?> getInfo (String name) {

        CountryClient countryClient = new CountryClient();
        CountryEntity country = this.countryRepository.findByName(name);

        if (country == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok(countryClient.getInfo(country));
        }
    }

    public ResponseEntity<List<CountryEntity>> getBetweenId (Integer id_min, Integer id_max) {

        return ResponseEntity.ok(countryRepository.findAllByIdBetween(id_min, id_max));
    }

    public ResponseEntity<List<CountryEntity>> getGreaterId (Integer id) {

        return ResponseEntity.ok(countryRepository.findAllByIdGreaterThan(id));
    }

    public ResponseEntity<List<CountryEntity>> getLesserId (Integer id) {

        return ResponseEntity.ok(countryRepository.findAllByIdIsLessThan(id));
    }

    public ResponseEntity<?> add (CountryEntity country) {

        CountryEntity c = countryRepository.findOne(country.getId());

        if (c == null){
            try {

                this.countryRepository.save (country);

            } catch (Exception e) {

                return ResponseEntity.badRequest().build ();
            }

            return ResponseEntity.noContent().build ();

        } else {

            return ResponseEntity.unprocessableEntity().body("El País ya existe.");
        }
    }

    public ResponseEntity<?> update (CountryEntity country, Integer id) {

        CountryEntity c = countryRepository.findOne(id);

        if (c == null) {

            return ResponseEntity.notFound().build();

        } else {

            try {

                c.setName(country.getName());
                this.countryRepository.save(c);

            } catch (Exception e) {

                return ResponseEntity.unprocessableEntity().build();
            }

            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<?> delete (Integer id) {

        CountryEntity country = countryRepository.findOne(id);
        List<ProvinceEntity> provinces = provinceRepository.findAllByCountry(country);

        if (country == null) {

            return ResponseEntity.notFound().build();

        } if (!provinces.isEmpty()) {

            return ResponseEntity.status (HttpStatus.CONFLICT).body("Pais referenciado por una o mas provincias!");

        } else {

            this.countryRepository.delete(id);
            return ResponseEntity.noContent().build();

        }
    }
}
