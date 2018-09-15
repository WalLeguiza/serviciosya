package com.cagmeini.serviciosya.service.test.orm;

import com.cagmeini.serviciosya.beans.entity.CityEntity;
import com.cagmeini.serviciosya.beans.entity.ProviderEntity;
import com.cagmeini.serviciosya.dao.IProviderDao;
import com.cagmeini.serviciosya.dao.orm.ProviderDaoHibernate;
import org.junit.Assert;
import org.junit.Test;


public class ProviderDaoTest {

    private IProviderDao dao = new ProviderDaoHibernate();

    @Test
    public void testCreate () {

        ProviderEntity p = new ProviderEntity ();
        p.setId(1);
        p.setName("Bart");
        p.setLastName("Simpson");
        p.setDni(1234);
        p.setEmail("bartsimpsons@gmail.com");
        p.setPhone ("1234567890");
        p.setAddress("Buenos Aires");
        CityEntity city = new CityEntity();
        city.setId(1);
        p.setCity(city);
        p.setStatus(0);
        this.dao.update (p);

        Assert.assertNotNull ("Failure creating new provider.", p.getId ());
    }


    @Test
    public void testFindAll () {


        ProviderEntity p = this.dao.findById (1);

        p.getOccupations().forEach( e -> System.out.println (e.getName ()));

        Assert.assertFalse ("Failure find all provider.", p.getOccupations().isEmpty());
    }

    @Test
    public void testFindByDNI () {

        ProviderEntity p = this.dao.findByDNI (1234);

        Assert.assertNotNull ("Failure find by dni.", p);
    }
}
