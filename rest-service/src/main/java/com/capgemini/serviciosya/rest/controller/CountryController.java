package com.capgemini.serviciosya.rest.controller;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.repository.ICountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping ("countries")
public class CountryController {

    @Autowired
    private ICountryRepository countryRepository;

    public CountryController() {

        super ();
    }

    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get () {

        // Return the value.
        return ResponseEntity.ok (this.countryRepository.findAll());
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get (@PathVariable("id") Integer id) {


        CountryEntity country = this.countryRepository.findOne (id);

        if (country == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok (this.countryRepository.findOne (id));
        }
    }

    @RequestMapping (method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> save (@RequestBody Map<String, Object> data) {

        try {

            CountryEntity country = new CountryEntity();
            country.setName ((String)data.get ("name"));

            this.countryRepository.save (country);

        } catch (Exception e) {

            return ResponseEntity.badRequest ().build ();
        }

        return ResponseEntity.noContent().build ();
    }

    @RequestMapping (value="/{id}", method = RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> save (@RequestBody Map<String, Object> data, @PathVariable ("id") int id) {

        try {

            CountryEntity country = new CountryEntity();
            country.setId (id);
            country.setName ((String)data.get ("name"));

            this.countryRepository.save (country);

        } catch (Exception e) {

            return ResponseEntity.unprocessableEntity().build ();
        }

        return ResponseEntity.noContent().build ();
    }
}
