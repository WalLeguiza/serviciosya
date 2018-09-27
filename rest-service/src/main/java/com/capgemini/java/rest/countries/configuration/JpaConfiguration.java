package com.capgemini.java.rest.countries.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.capgemini.serviciosya.repository"})
public class JpaConfiguration {

    private Environment env = null;


    public JpaConfiguration() {

        super ();
    }


    @Autowired
    public void setEnvironment (Environment env) {

        this.env = env;
    }


    @Bean
    public DataSource dataSource () {

        return DataSourceBuilder.create ()
                .username (env.getProperty ("db.username"))
                .password (env.getProperty ("db.password"))
                .url (env.getProperty ("db.url"))
                .driverClassName (env.getProperty ("db.driver"))
                .build ();
    }
}
