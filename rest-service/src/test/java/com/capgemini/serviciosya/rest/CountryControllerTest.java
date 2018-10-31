package com.capgemini.serviciosya.rest;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.rest.controller.CountryController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Type;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CountryControllerTest {

    private Client client;
    private WebResource webResource;

    private static final String SERVER = "http://localhost:8090/api/countries";
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    private final Logger logger = LoggerFactory.getLogger (CountryController.class);

    public CountryControllerTest () {

        super ();
    }

    @Before
    public void setUp () {

        this.client = Client.create ();
        this.webResource = client.resource (SERVER);
    }

    @Test
    public void testGet () {

        logger.info("Starting test...");

        logger.debug("Setting test value...");
        ClientResponse response = webResource.accept ("application/json").get (ClientResponse.class);

        logger.debug ("Executing request...");
        logger.debug ("Checking response...");

        //Assert.

        //Checking status.
        assertTrue (String.format
                        ("Response status [%d] from server %s is invalid, expected 200.",response.getStatus (),SERVER),
                response.getStatus () == 200);

        String output = response.getEntity (String.class);

        //Checking content type (json).
        assertEquals(
                String.format("Response content type [%s] from server %s, is invalid expected json.",
                        response.getType().toString(), SERVER),
                CONTENT_TYPE, response.getType ().toString ());

        //Checking body content.
        assertNotNull(String.format("Response body content from server %s is empty !!!", SERVER), output.isEmpty());

        logger.info ("Finishing test...");
    }

/*    @Test
    public void testGetId () {

        logger.info("Starting test...");

        logger.debug("Setting test values...");
        this.webResource = client.resource (SERVER.concat("/3"));

        logger.debug("Executing request...");
        ClientResponse response = webResource.get (ClientResponse.class);

        Gson gson = new Gson();
        Type type = new TypeToken<List<CountryEntity>>(){}.getType();
        String output = response.getEntity(String.class);
        List<CountryEntity> countriesList = gson.fromJson (output, type);

        assertFalse(String.format("Response body content from server %s is empty!!", SERVER),
                countriesList.isEmpty());

        assertTrue(String.format("Response body content from server %s returned more than one value!!", SERVER),
                countriesList.size() == 1);

        countriesList.forEach (e -> logger.debug (e.toString ()));

        logger.info ("Finishing test...");
    }*/
}
