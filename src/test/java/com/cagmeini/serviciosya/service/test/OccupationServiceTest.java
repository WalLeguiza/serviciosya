
package com.cagmeini.serviciosya.service.test;


import java.util.List;

import com.cagmeini.serviciosya.dao.IOccupationDao;
import com.cagmeini.serviciosya.dao.OccupationDaoMemory;
import com.cagmeini.serviciosya.dao.OccupationJdbcDao;
import org.junit.Assert;
import org.junit.Test;

import com.cagmeini.serviciosya.beans.domain.Occupation;
import com.cagmeini.serviciosya.service.OccupationService;


public class OccupationServiceTest {


    private OccupationService occupationService = new OccupationService ();

    private IOccupationDao occupationDao = new OccupationDaoMemory ();

    private IOccupationDao occupationJdbcDao = new OccupationJdbcDao();


    @Test
    public void testFindAllOccupations () {


        this.occupationService.setOccupationDao (this.occupationDao);

        List<Occupation> list = this.occupationService.findAllOccupations ();

        Assert.assertFalse (list.isEmpty ());
    }

    @Test
    public void testAddOccupation () {


        this.occupationService.setOccupationDao (this.occupationDao);

        Occupation o = new Occupation ("1", "Catador de Ron", "Beber alcohol...");

        List<Occupation> init = this.occupationDao.findAllOccupations ();

        this.occupationService.addOccupation (o);

        List<Occupation> end = this.occupationDao.findAllOccupations ();

        Assert.assertTrue (init.size()+1 == end.size());
    }

    @Test
    public void testFindByIdOccupation () {

        this.occupationService.setOccupationDao (this.occupationDao);

        Occupation o = new Occupation ("1", "Desarrollador", "Desarrollador java");

        this.occupationService.addOccupation (o);

        Occupation o1 = this.occupationService.findByIdOccupation("1");

        Assert.assertTrue("Failed for findByID (assertTrue)", o.getId().equals(o1.getId()));

        Occupation o2 = this.occupationService.findByIdOccupation("40");

        Assert.assertFalse("Failed for findByID (assertFalse)", o.getId().equals(o2.getId()));
    }

    @Test
    public void testUpdateOccupation () {

        this.occupationService.setOccupationDao (this.occupationDao);

        Occupation o = new Occupation ("1", "Desarrollador", "Desarrollador java");

        this.occupationService.addOccupation(o);

        this.occupationService.updateOccupation("1", "Catador de whisky", "Catador de whisky");

        Assert.assertFalse("Failed asserTrue.......", o.getName().equals("Desarrollador"));
    }

    @Test
    public void testRemoveByIdOccupation () {

        this.occupationService.setOccupationDao (this.occupationDao);

        Occupation o = new Occupation ("1", "Desarrollador", "Desarrollador java");
        this.occupationService.addOccupation(o);

        List<Occupation> init = occupationService.findAllOccupations();

        this.occupationService.removeByIdOccupation("1");

        List<Occupation> end = occupationService.findAllOccupations();

        Assert.assertTrue(init.size()-1 == end.size());
    }

    @Test
    public void testRemoveOccupation () {

        this.occupationService.setOccupationDao (this.occupationDao);

        Occupation o = new Occupation ("1", "Desarrollador", "Desarrollador java");
        this.occupationService.addOccupation(o);

        List<Occupation> init = occupationService.findAllOccupations();

        this.occupationService.removeOccupation(o);

        List<Occupation> end = occupationService.findAllOccupations();

        Assert.assertTrue(init.size()-1 == end.size());
    }

    @Test
    public void testFindAllOccupation () {

        this.occupationService.setOccupationDao (this.occupationJdbcDao);

        List<Occupation> list = this.occupationService.findAllOccupations();

        Assert.assertFalse ("Failed findAllOccupation..", list.isEmpty ());

        //Assert.assertTrue("Failed..", list.size()==1);
    }

    /*@Test
    public void testAddOccupation () {

        this.occupationService.setOccupationDao (this.occupationJdbcDao);

        Occupation o = new Occupation ("1", "Catador de Ron", "Beber alcohol...");

        this.occupationService.addOccupation();

        Assert.assertTrue();
    }*/
}