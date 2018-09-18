package com.cagmeini.serviciosya.service.test.orm;

import com.cagmeini.serviciosya.dao.ICountryDao;
import org.junit.Assert;
import org.junit.Test;

import com.cagmeini.serviciosya.beans.entity.OccupationEntity;
import com.cagmeini.serviciosya.dao.IOccupationDao;
import com.cagmeini.serviciosya.dao.orm.OccupationDaoHibernate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class OccupationDaoTest {

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");

    private IOccupationDao dao = context.getBean (IOccupationDao.class);

    @Test
    public void testCreate () {

        OccupationEntity c = new OccupationEntity ();
        c.setId (25);

        OccupationEntity o = new OccupationEntity ();
        o.setName ("Ingeniería en Petroleo");
        o.setDescription ("Profesión que consiste en la aplicación de los fundamentos del petroleo.");
        o.setOccupation(c);

        this.dao.create (o);

        Assert.assertNotNull ("Failure creating new province.", o.getId ());
    }

    @Test
    public void testUpdate () {

        OccupationEntity c = new OccupationEntity ();
        c.setId (25);

        OccupationEntity o = new OccupationEntity ();
        o.setId(27);
        o.setName ("Ingeniería Electrónica");
        o.setDescription ("Profesión que consiste en la aplicación de los fundamentos de la ciencia de la electrónica.");
        o.setOccupation(c);

        this.dao.update (o);

        Assert.assertEquals ("Failure updating occupation.", "Ingeniería Electrónica", o.getName ());
    }

    @Test
    public void testDelete () {

        int id = 20;
        this.dao.delete (id);

        OccupationEntity c = this.dao.findById (id);

        Assert.assertNull ("Failure deleting Occupation.", c);
    }

    @Test
    public void testFindAll () {

        List<OccupationEntity> list = this.dao.findAll ();

        list.forEach (e -> System.out.println (e.getName () + ": " + e.getDescription()));

        Assert.assertFalse ("Failure find all occupations.", list.isEmpty ());
    }
}
