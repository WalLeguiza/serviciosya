package com.capgemini.serviciosya.rest.controller;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.repository.ICountryRepository;

import com.capgemini.serviciosya.repository.IProvinceRepository;
import com.capgemini.serviciosya.rest.client.CountryClient;
import com.capgemini.serviciosya.rest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *
 *  <p>The class <code>com.capgemini.serviciosya.rest.controller.CountryController<code/>
 *  is controller object for the management of messages HTTP.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@RestController
@RequestMapping ("countries")
public class CountryController {

    @Autowired
    private ICountryRepository countryRepository;

    @Autowired
    private IProvinceRepository provinceRepository;

    @Autowired
    private CountryService countryService;

    /**
     *
     *
     * <p>Constructor without arguments
     */
    public CountryController() {

        // Call to super class.
        super ();
    }

    /**
     *
     *  <p>Return a JSON file with all the countries of the database.
     *
     *  @Method GET
     *  @return Return the countries.
     * */
    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAll () {

        return countryService.getAll();
    }

    /**
     *
     *  <p>Return a JSON file with a country of the database.
     *
     *  @Method GET
     *  @return Return a country by id.
     * */
    @RequestMapping (value = "/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CountryEntity> getId (@PathVariable("id") Integer id) {

        return countryService.getId(id);
    }

    @RequestMapping (value = "info/{name}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getInfo (@PathVariable("name") String name) {

        return countryService.getInfo(name);
    }

    @RequestMapping (value = "/between", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CountryEntity>> getBetweenId (@RequestParam ("id_min") Integer id_min, @RequestParam ("id_max") Integer id_max) {

        return countryService.getBetweenId(id_min, id_max);
    }

    @RequestMapping (value = "/greater", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CountryEntity>> getGreaterId (@RequestParam ("id_min") Integer id_min) {

        return countryService.getGreaterId(id_min);
    }

    @RequestMapping (value = "/lesser", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CountryEntity>> getLesserId (@RequestParam ("id_max") Integer id_max) {

        return countryService.getLesserId(id_max);
    }

    /**
     *
     *  <p>Add a country to database.
     *
     *  @Method POST
     * */
    @RequestMapping (method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> add (@RequestBody CountryEntity country) {

        return countryService.add(country);
    }

    /**
     *
     *  <p>Update a country to database.
     *
     *  @Method PUT
     * */
    @RequestMapping (value="/{id}", method = RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> update (@RequestBody CountryEntity country, @PathVariable ("id") int id) {

        return countryService.update(country, id);
    }

    /**
     *
     *  <p>Delete a country to database.
     *
     *  @Method DELETE
     * */
    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") int id) {

        return countryService.delete(id);

    }



}
