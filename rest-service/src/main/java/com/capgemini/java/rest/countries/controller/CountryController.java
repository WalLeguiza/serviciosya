package com.capgemini.java.rest.countries.controller;

import com.capgemini.serviciosya.repository.ICountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("countries")
public class CountryController {

    private ICountryRepository countryRepository;

    public CountryController() {

        super ();
    }

    @Autowired
    public void setCountryRepository (ICountryRepository countryRepository) {

        this.countryRepository = countryRepository;
    }

    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get () {

        // Return the value.
        return ResponseEntity.ok (this.countryRepository.findAll());
    }
}
