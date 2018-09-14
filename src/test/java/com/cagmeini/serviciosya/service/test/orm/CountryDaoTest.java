package com.cagmeini.serviciosya.service.test.orm;


import org.junit.Assert;
import org.junit.Test;

import com.cagmeini.serviciosya.beans.entity.CountryEntity;
import com.cagmeini.serviciosya.dao.ICountryDao;
import com.cagmeini.serviciosya.dao.orm.CountryDaoHibernate;

import java.util.List;


public class CountryDaoTest {

    private ICountryDao dao = new CountryDaoHibernate ();

    @Test
    public void testCreate () {

        CountryEntity c = new CountryEntity ();
        c.setName ("Uruguay");

        this.dao.create (c);

        Assert.assertNotNull ("Failure creating new country.", c.getId ());
    }

    @Test
    public void testUpdate () {

        CountryEntity c = new CountryEntity ();
        c.setId (4);

        c.setName ("Venezuela");

        this.dao.update (c);

        Assert.assertEquals ("Failure updating Country.", "Venezuela", c.getName ());
    }

    @Test
    public void testDelete () {

        int id = 2;
        this.dao.delete (4);

        CountryEntity c = this.dao.findById (id);

        Assert.assertNull ("Failure deleting Country.", c);
    }

    @Test
    public void testFindAll () {

        List<CountryEntity> list = this.dao.findAll ();

        list.forEach (e -> System.out.println (e.getName ()));

        Assert.assertFalse ("Failure find all provinces.", list.isEmpty ());
    }
}
