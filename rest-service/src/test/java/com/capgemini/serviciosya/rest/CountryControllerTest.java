package com.capgemini.serviciosya.rest;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountryControllerTest {

    @Autowired
    private static final String SERVICE_URL = "http://localhost:8090/api/countries";

    @Test
    public void get () throws ClientProtocolException, IOException {

        HttpUriRequest request = new HttpGet (SERVICE_URL);

        HttpResponse httpResponse = HttpClientBuilder
                .create ()
                .build ()
                .execute (request);

        Assert.assertEquals (httpResponse
                .getStatusLine ()
                .getStatusCode (), 200);
    }

    @Test
    public void getId () throws ClientProtocolException, IOException {

        HttpUriRequest request = new HttpGet (SERVICE_URL + "/1");

        HttpResponse httpResponse = HttpClientBuilder
                .create ()
                .build ()
                .execute (request);

        Assert.assertEquals (httpResponse
                .getStatusLine ()
                .getStatusCode (), 200);
    }
}
