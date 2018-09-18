package com.cagmeini.serviciosya.beans.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;


import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.Set;
import java.util.HashSet;

@NamedQueries ({

        @NamedQuery(

                name  = "ProviderFindByPhone",
                query = "from Provider p where p.phone = :phone"
        )
})

@Entity (name = "Provider")
@Table (name = "provider")
public class ProviderEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    @Column (name = "lastName", length = 48, nullable = false)
    private String lastName;

    @Column (name = "phone", length = 48, nullable = false, unique = true)
    private String phone;

    @Column (name = "dni", nullable = false, unique = true)
    private Integer dni;

    @Email
    @Column (name = "email", length = 128, nullable = false, unique = true)
    private String email;

    @Column (name = "address", length = 128, nullable = false)
    private String address;

    @Range (min = 0, max = 2)
    @Column (name = "status", nullable = false)
    private Integer status;

    @ManyToOne
    @JoinColumn (name = "city_id")
    private CityEntity city;

    @ManyToMany (cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable (name = "occupation_x_provider",
                joinColumns = {@JoinColumn (name = "provider_id")},
                inverseJoinColumns = {@JoinColumn (name = "occupation_id")})
    private Set<OccupationEntity> occupations = new HashSet<> ();

    /**
     *
     *
     * <p>Constructor without arguments
     */
    public ProviderEntity() {

        super ();
    }

    /**
     *
     *
     * <p>Constructor with arguments
     */
    public ProviderEntity(int id, String name, String lastName, String phone,
                          Integer dni, String email, String address, Integer status,
                          CityEntity city, Set<OccupationEntity> occupations) {

        super ();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.dni = dni;
        this.email = email;
        this.address = address;
        this.status = status;
        this.city = city;
        this.occupations = occupations;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public Set<OccupationEntity> getOccupations() {
        return occupations;
    }

    public void setOccupations(Set<OccupationEntity> occupations) {
        this.occupations = occupations;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
