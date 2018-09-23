package com.capgemini.serviciosya.beans.domain;

/**
 *
 *  <p>The class <code>com.capgemini.serviciosya.beans.domain.Adress<code/>
 *  is a domain object for management the persons adress information.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
public class Address {

    // Private instances fields.

    // Address id.
    private String id;

    // Address street.
    private String street;

    // Address number.
    private String number;

    // Address location.
    private String location;

    // Address province.
    private String province;

    // Address zip.
    private String zip;

    /**
     *
     *  <p>Constructor without arguments.
     * */
    public Address() {

        super();
    }

    /**
     *
     *  <p>Constructor with arguments.
     *
     *  @param id Id address.
     *  @param street Street Address.
     *  @param number Number Address.
     *  @param location Location Address.
     *  @param province Province Address.
     *  @param zip Zip Address.
     * */
    public Address(String id, String street, String number, String location, String province, String zip) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
        this.zip = zip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     *
     *
     * @return  a string representation of the address.
     */
    @Override
    public String toString() {
        return  this.street + ", "+
                this.number + ", " +
                this.location + ", " +
                this.province + ", " +
                this.zip;
    }
}
