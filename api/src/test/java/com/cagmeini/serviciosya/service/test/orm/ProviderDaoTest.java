package com.cagmeini.serviciosya.service.test.orm;

import com.cagmeini.serviciosya.beans.entity.CityEntity;
import com.cagmeini.serviciosya.beans.entity.ProviderEntity;
import com.cagmeini.serviciosya.dao.IProviderDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ProviderDaoTest {

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");

    private IProviderDao dao = context.getBean (IProviderDao.class);

    @Test
    public void testCreate () {

        ProviderEntity p = new ProviderEntity ();
        p.setName("Bob");
        p.setLastName("Patiño");
        p.setDni(8521);
        p.setEmail("bpatiño@gmail.com");
        p.setPhone ("45612378");
        p.setAddress("Buenos Aires");
        CityEntity city = new CityEntity();
        city.setId(1);
        p.setCity(city);
        p.setStatus(0);
        this.dao.create (p);

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
