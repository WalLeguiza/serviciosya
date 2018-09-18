package com.cagmeini.serviciosya.beans.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity (name = "Consumer")
@Table (name = "consumer")
public class ConsumerEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    @Column (name = "lastname", length = 48, nullable = false)
    private String lastName;

    @Column (name = "dni", nullable = false, unique = true)
    private Integer dni;

    @Email
    @Column (name = "email", length = 128, nullable = false, unique = true)
    private String email;

    @Column (name = "phone", length = 48, nullable = false, unique = true)
    private String phone;

    @ManyToOne
    @JoinColumn (name = "city_id")
    private CityEntity city_id;

    @Column (name = "address", length = 128, nullable = false)
    private String address;

    @Range (min = 0, max = 2)
    @Column (name = "status", nullable = false)
    private Integer status;

    /**
     *
     *
     * Constructor without arguments
     */
    public ConsumerEntity() {

        super ();
    }

    /**
     *
     *
     * Constructor with arguments
     */
    public ConsumerEntity(int id, String name, String lastName, Integer dni,
                          String email, String phone, CityEntity city_id,
                          String address, Integer status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
        this.city_id = city_id;
        this.address = address;
        this.status = status;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CityEntity getCity_id() {
        return city_id;
    }

    public void setCity_id(CityEntity city_id) {
        this.city_id = city_id;
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

    @Override
    public String toString() {
        return name;
    }
}
