package com.capgemini.serviciosya.rest;

import com.capgemini.serviciosya.rest.controller.CountryController;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration () {

        register(CountryController.class);
    }
}
