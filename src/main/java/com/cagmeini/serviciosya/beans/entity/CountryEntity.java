package com.cagmeini.serviciosya.beans.entity;

import javax.persistence.*;

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
    public CountryEntity() {

        super ();
    }

    /**
     *
     *
     * <p>Constructor with arguments
     */
    public CountryEntity(int id, String name) {

        super ();
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
}
