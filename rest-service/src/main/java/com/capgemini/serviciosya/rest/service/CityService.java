package com.capgemini.serviciosya.rest.service;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.repository.ICityRepository;
import com.capgemini.serviciosya.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private ICityRepository cityRepository;

    @Autowired
    private IProvinceRepository provinceRepository;

    public CityService () {

        super();
    }

    public ResponseEntity<List<CityEntity>> getAll () {

        return ResponseEntity.ok(this.cityRepository.findAll());
    }

    public ResponseEntity<CityEntity> getId (Integer id) {

        CityEntity city = this.cityRepository.findOne(id);

        if (city == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok(city);
        }
    }

    public ResponseEntity<List<CityEntity>> getAllByProvince (String nameProvince) {

        ProvinceEntity province = this.provinceRepository.findByName(nameProvince);

        if (province == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok(this.cityRepository.findAllByProvince(province));
        }
    }

    public ResponseEntity<?> add (CityEntity city) {

        try {

            this.cityRepository.save(city);

        } catch (Exception e) {

            return ResponseEntity.badRequest().build();

        }

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<?> update (CityEntity city, Integer id) {

        CityEntity c = this.cityRepository.findOne(id);

        if (c == null) {

            return ResponseEntity.notFound().build();

        } else {

            try {

                c.setName(city.getName());
                c.setProvince(city.getProvince());
                this.cityRepository.save (c);

            } catch (Exception e) {

                return ResponseEntity.unprocessableEntity ().build ();
            }

            return ResponseEntity.noContent().build ();
        }
    }

    public ResponseEntity<?> delete (Integer id) {

        CityEntity city = this.cityRepository.findOne(id);

        if (city == null) {

            return ResponseEntity.notFound().build();

        } else {

            this.cityRepository.delete(id);
            return ResponseEntity.noContent().build();
        }
    }
}
