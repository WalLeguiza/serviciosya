package com.capgemini.serviciosya.rest.controller;

import com.capgemini.serviciosya.beans.entity.CityEntity;

import com.capgemini.serviciosya.rest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 *  <p>The class <code>com.capgemini.serviciosya.rest.controller.CityController<code/>
 *  is controller object for the management the messages HTTP.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@RestController
@RequestMapping ("cities")
public class CityController {

    // CityController city repository.
    @Autowired
    private CityService cityService;

    /**
     *
     *
     * <p>Constructor without arguments
     */
    public CityController() {

        // Call to super class.
        super ();
    }

    /**
     *
     *  <p>Return a JSON file with all the cities in the database.
     *
     *  @Method GET
     *  @return Return the cities.
     * */
    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get () {

        // Return the value.
        return this.cityService.getAll();
    }

    /**
     *
     *  <p>Return a JSON file with a city of the database.
     *
     *  @Method GET
     *  @return Return a city by id.
     * */
    @RequestMapping (value = "/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get (@PathVariable("id") Integer id) {


        return this.cityService.getId(id);
    }

    @RequestMapping (value = "/province/{nameProvince}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllByProvince (@PathVariable("nameProvince") String nameProvince) {

        return this.cityService.getAllByProvince(nameProvince);
    }

    /**
     *
     *  <p>Add a city to database.
     *
     *  @Method POST
     * */
    @RequestMapping (method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> add (@RequestBody CityEntity city) {

        return this.cityService.add(city);
    }

    /**
     *
     *  <p>Update a city to database.
     *
     *  @Method PUT
     * */
    @RequestMapping (value="/{id}", method = RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> update (@RequestBody CityEntity city, @PathVariable ("id") int id) {

        return this.cityService.update(city, id);
    }

    /**
     *
     *  <p>Delete a city to database.
     *
     *  @Method DELETE
     * */
    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") int id) {

        return this.cityService.delete(id);
    }
}
