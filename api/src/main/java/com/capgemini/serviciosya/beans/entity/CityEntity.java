package com.capgemini.serviciosya.beans.entity;

import javax.persistence.*;

/**
 *
 *  <p>The class <code>com.capgemini.serviciosya.beans.entity.CityEntity<code/>
 *  is a entity object for mapping the cities information of the data base.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@Entity (name = "City")
@Table (name = "city")
public class CityEntity {

    // Map the fields (Database Table) and properties (Java Classes)

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn (name = "province_id")
    private ProvinceEntity province;

    /**
     *
     *
     * <p>Constructor without arguments
     */
    public CityEntity() {

        super ();
    }

    /**
     *
     *
     * <p>Constructor with arguments
     *
     * @param id Id city.
     * @param name Name city.
     * @param province Province city.
     */
    public CityEntity(int id, String name, ProvinceEntity province) {

        super();
        this.id = id;
        this.name = name;
        this.province = province;
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

    public ProvinceEntity getProvince() {
        return province;
    }

    public void setProvince(ProvinceEntity province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return  this.name + ", " + this.province;
    }
}
