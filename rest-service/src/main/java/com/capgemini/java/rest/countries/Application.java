package com.capgemini.java.rest.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = { "com.capgemini.serviciosya.beans.entity" })
@EnableJpaRepositories(basePackages = { "com.capgemini.serviciosya.repository" })
public class Application {

    public Application () {

        super ();
    }

    public static void main (String[] args) {

        SpringApplication.run (Application.class, args);
    }
}
