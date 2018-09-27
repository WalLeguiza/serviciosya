package com.capgemini.serviciosya.beans.entity;

import javax.persistence.*;

/**
 *
 *  <p>The class <code>com.capgemini.serviciosya.beans.entity.CountryEntity<code/>
 *  is a entity object for mapping the countries information of the data base.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@Entity (name = "Country")
@Table (name = "country")
public class CountryEntity {

    // Map the fields (Database Table) and properties (Java Classes)
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    /**
     *
     *
     * <p>Constructor without arguments
     */
    public CountryEntity () {

        // Call to super class.
        super ();
    }

    /**
     *
     *
     * <p>Constructor with arguments
     *
     * @param id Id country.
     * @param name Name country.
     */
    public CountryEntity(int id, String name) {
        // Call to super class.
        super ();

        // Set internal values.
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
