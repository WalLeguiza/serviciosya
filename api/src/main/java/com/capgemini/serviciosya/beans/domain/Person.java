package com.capgemini.serviciosya.beans.domain;

import java.util.Date;

public abstract class Person {

    // Private instances fields.

    // Person id.
    private String id;

    // Person name.
    private String name;

    // Person last_name
    private String last_name;

    // Person dni.
    private String dni;

    // Person birthday.
    private Date birthday;

    // Person email.
    private String email;

    // Person phone.
    private  String phone;

    //Person address.
    private Address address;

    /**
     *
     *  <p>The class <code>com.capgemini.serviciosya.beans.domain.Person<code/>
     *  is a domain object abstract for management the persons information.
     *
     *  @author Walter Leguiza (wal.leguiza@gmail.com)
     *  @version 1.0.0
     *  @since 1.8
     * */
    public Person() {

        super();
    }

    /**
     *
     *  <p>Constructor with arguments.
     *
     *  @param id Id Person.
     *  @param name Name Person.
     *  @param last_name Last Name Person.
     *  @param dni DNI Person.
     *  @param birthday Birthday Person.
     *  @param email Email Person.
     *  @param phone Phone Person.
     *  @param address Address Person.
     * */
    public Person(String id, String name, String last_name, String dni, Date birthday, String email, String phone, Address address) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.dni = dni;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
