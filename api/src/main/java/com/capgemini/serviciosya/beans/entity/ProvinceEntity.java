package com.capgemini.serviciosya.beans.entity;

import javax.persistence.*;

/**
 *
 *  <p>The class <code>com.capgemini.serviciosya.beans.entity.ProvinceEntity<code/>
 *  is a entity object for mapping the provinces information of the data base.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@Entity (name = "Province")
@Table (name = "province")
public class ProvinceEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn (name="country_id")
    private CountryEntity country;

    /**
     *
     *
     * <p>Constructor without arguments
     */
    public ProvinceEntity() {

        super ();
    }

    /**
     *
     *
     * <p>Constructor with arguments
     *
     * @param id Id province.
     * @param name Name province.
     * @param country Country province.
     */
    public ProvinceEntity(int id, String name, CountryEntity country) {

        super ();
        this.id = id;
        this.name = name;
        this.country = country;
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

    public CountryEntity getCountry () {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.country;
    }
}
