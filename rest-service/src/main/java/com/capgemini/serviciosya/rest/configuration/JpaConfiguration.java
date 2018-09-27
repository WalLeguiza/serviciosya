package com.capgemini.serviciosya.rest.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 *
 *  <p>The class <code>com.capgemini.serviciosya.rest.configuration.JpaConfiguration<code/>
 *  is configuration object for the connection with JPA.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@Configuration
@EnableJpaRepositories (basePackages = {"com.capgemini.serviciosya.repository"})
@EnableTransactionManagement
public class JpaConfiguration {

    // JpaConfiguration environment.
    private Environment env = null;

    /**
     *
     *
     * <p>Constructor without arguments
     */
    public JpaConfiguration () {

        // Call to super class.
        super ();
    }

    /**
     *
     *  <p>Set the JpaConfiguration enviroment.
     *
     *  @param env Set the JpaConfiguration enviroment.
     * */
    @Autowired // Spring boot auto injection.
    public void setEnvironment (Environment env) {

        // Set the value.
        this.env = env;
    }

    @Bean (destroyMethod = "close") // Object configured and instantiated in the Spring container.
    public ComboPooledDataSource dataSource () throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource ();

        // Set properties
        dataSource.setMinPoolSize (Integer.parseInt (env.getProperty ("hibernate.c3p0.min_size")));
        dataSource.setMaxPoolSize (Integer.parseInt (env.getProperty ("hibernate.c3p0.max_size")));
        dataSource.setMaxIdleTime (Integer.parseInt(env.getProperty ("hibernate.c3p0.idle_test_period")));
        dataSource.setJdbcUrl (env.getProperty ("db.url"));
        dataSource.setPassword (env.getProperty ("db.password"));
        dataSource.setUser (env.getProperty ("db.username"));
        dataSource.setDriverClass (env.getProperty ("db.driver"));

        // Return the new datasource.
        return dataSource;
    }

    @Bean // Object configured and instantiated in the Spring container.
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean ();
        entityManagerFactory.setDataSource (dataSource);

        entityManagerFactory.setPackagesToScan (env.getProperty ("entitymanager.packagesToScan"));

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter ();
        entityManagerFactory.setJpaVendorAdapter (vendorAdapter);

        Properties additionalProperties = new Properties ();
        additionalProperties.put ("hibernate.dialect", env.getProperty ("hibernate.dialect"));
        additionalProperties.put ("hibernate.show_sql", env.getProperty ("hibernate.show_sql"));
        additionalProperties.put ("hibernate.hbm2ddl.auto", env.getProperty ("hibernate.hbm2ddl.auto"));

        entityManagerFactory.setJpaProperties (additionalProperties);

        return entityManagerFactory;
    }

    @Bean // Object configured and instantiated in the Spring container.
    public JpaTransactionManager transactionManager (EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager transactionManager = new JpaTransactionManager ();
        transactionManager.setEntityManagerFactory (entityManagerFactory);

        return transactionManager;
    }

    @Bean // Object configured and instantiated in the Spring container.
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation () {

        return new PersistenceExceptionTranslationPostProcessor ();
    }
}
