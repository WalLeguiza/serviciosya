package com.cagmeini.serviciosya.service.test.orm;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import com.cagmeini.serviciosya.beans.entity.CityEntity;
import com.cagmeini.serviciosya.beans.entity.ProvinceEntity;
import com.cagmeini.serviciosya.dao.ICityDao;
import com.cagmeini.serviciosya.dao.orm.CityDaoHibernate;

public class CityDaoTest {

    private ICityDao dao = new CityDaoHibernate ();

    @Test
    public void testCreate () {

        ProvinceEntity p = new ProvinceEntity ();
        p.setId (5);

        CityEntity c = new CityEntity ();
        c.setName ("Posadas");
        c.setProvince (p);

        this.dao.create (c);

        Assert.assertNotNull ("Failure creating new city.", c.getId ());
    }

    @Test
    public void testUpdate () {

        ProvinceEntity p = new ProvinceEntity ();
        p.setId (5);

        CityEntity c = new CityEntity ();
        c.setId (2);
        c.setName ("Posadas");
        c.setProvince (p);
        this.dao.update (c);

        Assert.assertEquals ("Failure updating city.", "Posadas", c.getName ());
    }

    @Test
    public void testDelete () {

        int id = 2;
        this.dao.delete (id);

        CityEntity c = this.dao.findById (id);

        Assert.assertNull ("Failure deleting city.", c);
    }

    @Test
    public void testFindAll () {

        List<CityEntity> list = this.dao.findAll ();

        list.forEach (e -> System.out.println (e.getName () + " -> " + e.getProvince ().getName ()));

        Assert.assertFalse ("Failure find all cities.", list.isEmpty ());
    }
}
