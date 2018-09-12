package com.cagmeini.serviciosya.beans.domain;

public class Country {

    // Private instances fields.

    // Country id.
    private int id;

    // Country name
    private String name;

    // Constructor declarations.
    /**
     *
     *  <p>Constructor without arguments.
     * */
    public Country() {

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
}
