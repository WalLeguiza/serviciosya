package com.capgemini.serviciosya.rest.controller;

import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.repository.ICityRepository;
import com.capgemini.serviciosya.repository.IProvinceRepository;

import com.capgemini.serviciosya.rest.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 *  <p>The class <code>com.capgemini.serviciosya.rest.controller.ProvinceController<code/>
 *  is controller object for the management of messages HTTP.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@RestController
@RequestMapping ("provinces")
public class ProvinceController {

    @Autowired
    private IProvinceRepository provinceRepository;

    @Autowired
    private ICityRepository cityRepository;

    @Autowired
    private ProvinceService provinceService;

    /**
     *
     *
     * <p>Constructor without arguments
     */
    public ProvinceController() {

        // Call to super class.
        super ();
    }

    /**
     *
     *  <p>Return a JSON file with all the provinces in the database.
     *
     *  @Method GET
     *  @return Return the provinces.
     * */
    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAll () {

        // Return the value.
        return this.provinceService.getAll();
    }

    /**
     *
     *  <p>Return a JSON file with a province of the database.
     *
     *  @Method GET
     *  @return Return a province by id.
     * */
    @RequestMapping (value = "/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getId (@PathVariable("id") Integer id) {

        return provinceService.getId(id);
    }

    @RequestMapping (value = "/country/{nameCountry}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllByCountry (@PathVariable("nameCountry") String nameCountry) {

        return provinceService.getAllByCountry(nameCountry);
    }

    /**
     *
     *  <p>Add a province to database.
     *
     *  @Method POST
     * */
    @RequestMapping (method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> add (@RequestBody ProvinceEntity province) {

        return provinceService.add(province);
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
    public ResponseEntity<?> update (@RequestBody ProvinceEntity province, @PathVariable ("id") int id) {

        return provinceService.update(province, id);
    }

    /**
     *
     *  <p>Delete a province to database.
     *
     *  @Method DELETE
     * */
    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") int id) {

        return provinceService.delete(id);
    }
}
