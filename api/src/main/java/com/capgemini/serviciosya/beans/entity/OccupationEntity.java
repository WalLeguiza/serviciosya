package com.capgemini.serviciosya.beans.entity;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

/**
 *
 *  <p>The class <code>com.capgemini.serviciosya.beans.domain.OccupationEntity<code/>
 *  is a entity object for mapping the occupations information of the data base.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@Entity (name = "Occupation")
@Table (name = "occupation")
public class OccupationEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn (name = "parent")
    private OccupationEntity occupation;

    @ManyToMany (mappedBy = "occupations")
    private Set<ProviderEntity> providers = new HashSet();

    /**
     *
     *
     * <p>Constructor without arguments
     */
    public OccupationEntity() {

        super ();
    }

    /**
     *
     *  <p>Constructor with arguments.
     *
     *  @param id Id occupation.
     *  @param name Name occupation.
     *  @param description Description occupation.
     * */
    public OccupationEntity(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.occupation = occupation;
    }

    /**
     *
     *  <p>Constructor with arguments.
     *
     *  @param id Id occupation.
     *  @param name Name occupation.
     *  @param description Description occupation.
     *  @param occupation Parent occupation.
     * */
    public OccupationEntity(int id, String name, String description, OccupationEntity occupation) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.occupation = occupation;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OccupationEntity getOccupation() {
        return occupation;
    }

    public void setOccupation(OccupationEntity occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {

        return this.name + ": " + this.description;
    }
}
