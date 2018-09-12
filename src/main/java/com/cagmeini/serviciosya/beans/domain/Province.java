package com.cagmeini.serviciosya.beans.domain;

public class Province {

    // Private instances fields.

    // Province id.
    private int id;

    // Province name
    private String name;

    // Province countryId
    private int countryId;

    // Constructor declarations.
    /**
     *
     *  <p>Constructor without arguments.
     * */
    public Province() {

        super();
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

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
