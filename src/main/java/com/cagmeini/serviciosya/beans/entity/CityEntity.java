package com.cagmeini.serviciosya.beans.entity;

import javax.persistence.*;

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
}
