package com.cagmeini.serviciosya.dao;

import java.util.List;

import com.cagmeini.serviciosya.beans.domain.Client;

public interface IClient {

    List<Client> findAllOccupations ();

    void add (Client client);

    Client findById(String id);

    void update (String id, String name, String description);

    void remove (Client occupation);

    void removeById (String id);
}
