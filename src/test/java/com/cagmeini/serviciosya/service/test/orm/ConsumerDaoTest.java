package com.cagmeini.serviciosya.service.test.orm;

import com.cagmeini.serviciosya.beans.entity.CityEntity;
import com.cagmeini.serviciosya.beans.entity.ConsumerEntity;
import com.cagmeini.serviciosya.dao.IConsumerDao;
import com.cagmeini.serviciosya.dao.orm.ConsumerDaoHibernate;
import org.junit.Assert;
import org.junit.Test;
import org.postgresql.util.PGmoney;

import java.util.List;

public class ConsumerDaoTest {

    private IConsumerDao dao = new ConsumerDaoHibernate();

    @Test
    public void testCreate () {

        ConsumerEntity c = new ConsumerEntity();

        CityEntity city = new CityEntity();
        city.setId(1);

        c.setName("Marge");
        c.setLastName("Simpsons");
        c.setDni(3321);
        c.setEmail("marge@gmail.com");
        c.setPhone("5543210");
        c.setAddress("Buenos Aires");
        c.setCity_id(city);
        c.setStatus(0);

        dao.create(c);

        Assert.assertNotNull("Failure creating new consumer.", c.getId());

    }

    @Test
    public void testUpdate () {

        ConsumerEntity c = new ConsumerEntity();
        c.setId(5);

        CityEntity city = new CityEntity();
        city.setId(1);

        c.setName("Homer");
        c.setLastName("Simpsons");
        c.setDni(4321);
        c.setEmail("homer@gmail.com");
        c.setPhone("6543210");
        c.setAddress("Buenos Aires");
        c.setCity_id(city);
        c.setStatus(1);


        dao.update(c);

        Assert.assertTrue("Failure updating consumer", c.getStatus()==1);
    }

    @Test
    public void testDelete () {

        int id = 5;
        this.dao.delete (id);

        ConsumerEntity c = this.dao.findById (id);

        Assert.assertNull ("Failure deleting Province.", c);
    }

    @Test
    public void testFindAll () {

        List<ConsumerEntity> list = this.dao.findAll ();

        list.forEach (e -> System.out.println (e));

        Assert.assertFalse ("Failure find all consumers.", list.isEmpty ());
    }

    @Test
    public void testFindByEmail () {

        ConsumerEntity p = dao.findByEmail("marge@gmail.com");

        Assert.assertNotNull ("Failure find by Email", p);
    }

    @Test
    public void testFindByDni () {

        ConsumerEntity p = dao.findByDNI(4321);

        Assert.assertNotNull ("Failure find by DNI", p);
    }

    @Test
    public void testFindByPhone () {

        ConsumerEntity p = dao.findByPhone("6543210");

        Assert.assertNotNull ("Failure find by phone", p);
    }
}
