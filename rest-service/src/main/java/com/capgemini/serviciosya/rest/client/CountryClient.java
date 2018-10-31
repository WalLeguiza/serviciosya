package com.capgemini.serviciosya.rest.client;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CountryClient {

    private Client client;
    private WebResource webResource;

    private static final String SERVER = "https://restcountries.eu/rest/v2";

    public CountryClient() {

        super ();
        this.client = Client.create();
    }

    public String getInfo (CountryEntity country) {

        String uri = "/name/"+country.getName();

        this.webResource = client.resource(SERVER.concat(uri));

        ClientResponse response = webResource.get(ClientResponse.class);

        return response.getEntity(String.class);
    }
}
