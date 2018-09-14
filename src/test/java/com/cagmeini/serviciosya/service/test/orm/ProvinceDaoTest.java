package com.cagmeini.serviciosya.service.test.orm;

import org.junit.Assert;
import org.junit.Test;

import com.cagmeini.serviciosya.beans.entity.ProvinceEntity;
import com.cagmeini.serviciosya.beans.entity.CountryEntity;
import com.cagmeini.serviciosya.dao.IProvinceDao;
import com.cagmeini.serviciosya.dao.orm.ProvinceDaoHibernate;

import java.util.List;

public class ProvinceDaoTest {

    private IProvinceDao dao = new ProvinceDaoHibernate ();


    @Test
    public void testCreate () {

        ProvinceEntity p = new ProvinceEntity ();
        CountryEntity c = new CountryEntity ();
        c.setId (1);
        p.setName ("Misiones");
        p.setCountry (c);

        this.dao.create (p);

        Assert.assertNotNull ("Failure creating new province.", c.getId ());
    }

    @Test
    public void testUpdate () {

        CountryEntity c = new CountryEntity ();
        c.setId (1);

        ProvinceEntity p = new ProvinceEntity ();
        p.setId (2);
        p.setName ("Buenos Aires");
        p.setCountry (c);

        this.dao.update (p);

        Assert.assertEquals ("Failure updating Province.", "Buenos Aires", p.getName ());
    }

    @Test
    public void testDelete () {

        int id = 2;
        this.dao.delete (id);

        ProvinceEntity c = this.dao.findById (id);

        Assert.assertNull ("Failure deleting Province.", c);
    }

    @Test
    public void testFindAll () {

        List<ProvinceEntity> list = this.dao.findAll ();

        list.forEach (e -> System.out.println (e.getName () + " -> " + e.getCountry ().getName ()));

        Assert.assertFalse ("Failure find all provinces.", list.isEmpty ());
    }
}