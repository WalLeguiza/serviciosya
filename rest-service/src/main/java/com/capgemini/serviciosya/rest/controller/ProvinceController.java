package com.capgemini.serviciosya.rest.controller;

import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.repository.IProvinceRepository;

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
    public ResponseEntity<?> get () {

        // Return the value.
        return ResponseEntity.ok (this.provinceRepository.findAll());
    }

    /**
     *
     *  <p>Return a JSON file with a province of the database.
     *
     *  @Method GET
     *  @return Return a province by id.
     * */
    @RequestMapping (value = "/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get (@PathVariable("id") Integer id) {


        ProvinceEntity province = this.provinceRepository.findOne (id);

        if (province == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok (this.provinceRepository.findOne (id));
        }
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

        try {

            ProvinceEntity p = new ProvinceEntity();
            p.setName (province.getName ());
            p.setCountry (province.getCountry ());

            this.provinceRepository.save (p);

        } catch (Exception e) {

            return ResponseEntity.badRequest ().build ();
        }

        return ResponseEntity.noContent ().build ();
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

        try {

            ProvinceEntity p = new ProvinceEntity ();
            p.setId (id);
            p.setName (province.getName ());
            province.setCountry (province.getCountry ());

            this.provinceRepository.save (province);

        } catch (Exception e) {

            return ResponseEntity.unprocessableEntity ().build ();
        }

        return ResponseEntity.noContent().build ();
    }

    /**
     *
     *  <p>Delete a province to database.
     *
     *  @Method DELETE
     * */
    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") int id) {

        this.provinceRepository.delete(id);

        return ResponseEntity.noContent ().build ();
    }
}
