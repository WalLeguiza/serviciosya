package com.cagmeini.serviciosya.service.test.orm;


import org.junit.Assert;
import org.junit.Test;

import com.cagmeini.serviciosya.beans.entity.CountryEntity;
import com.cagmeini.serviciosya.dao.ICountryDao;
import com.cagmeini.serviciosya.dao.orm.CountryDaoHibernate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class CountryDaoTest {

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");

    private ICountryDao dao = context.getBean (ICountryDao.class);

    @Test
    public void testCreate () {

        CountryEntity c = new CountryEntity ();
        c.setName ("Colombia");

        this.dao.create (c);

        Assert.assertNotNull ("Failure creating new country.", c.getId ());
    }

    @Test
    public void testUpdate () {

        CountryEntity c = new CountryEntity ();
        c.setId (10);

        c.setName ("Colombia");

        this.dao.update (c);

        Assert.assertEquals ("Failure updating Country.", "Colombia", c.getName ());
    }

    @Test
    public void testDelete () {

        int id = 10;
        this.dao.delete (10);

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
