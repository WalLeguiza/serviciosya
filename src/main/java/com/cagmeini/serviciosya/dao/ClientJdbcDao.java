package com.cagmeini.serviciosya.dao;

import java.util.List;

import com.cagmeini.serviciosya.beans.domain.Client;

public class ClientJdbcDao implements IClient {

    @Override
    public List<Client> findAllOccupations() {
        return null;
    }

    @Override
    public void add(Client client) {

    }

    @Override
    public Client findById(String id) {
        return null;
    }

    @Override
    public void update(String id, String name, String description) {

    }

    @Override
    public void remove(Client occupation) {

    }

    @Override
    public void removeById(String id) {

    }
}
