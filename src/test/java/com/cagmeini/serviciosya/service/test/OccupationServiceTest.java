
package com.cagmeini.serviciosya.service.test;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.cagmeini.serviciosya.beans.domain.Occupation;
import com.cagmeini.serviciosya.dao.IOccupationDao;
import com.cagmeini.serviciosya.dao.OccupationDaoJDBC;

import java.util.List;

public class OccupationServiceTest {

    private static final Logger logger = Logger.getLogger (OccupationServiceTest.class);

    @Test
    public void testCreate () {

        try {

            //Insert new value
            logger.info ("Starting occupation add test.");
            IOccupationDao dao = new OccupationDaoJDBC ();

            logger.debug ("Inserting new occupation.");
            Occupation c = new Occupation ();
            c.setName ("Run tester.");
            c.setDescription ("xxxxxxxx");
            dao.create (c);

            logger.debug ("Checking test result.");
            List<Occupation> list = dao.findAll ();

            boolean r = Boolean.FALSE;

            for (Occupation item : list) {

                if (item.getName ().equals (c.getName ())) {
                    r = Boolean.TRUE;
                    break;
                }
            }

            logger.info("Finishing the test...");
            Assert.assertTrue(r);

        } catch (Exception e) {

            Assert.assertNull(e);
        }
    }

    @Test
    public void testDelete () {

        try {
            //Delete one register.
            logger.info("Starting occupation delete test.");
            IOccupationDao dao = new OccupationDaoJDBC();

            Occupation o = dao.findById(21);

            logger.debug ("Deleting one occupation.");
            dao.delete (o.getId());

            logger.debug ("Checking test result.");
            List<Occupation> list = dao.findAll ();

            boolean r = Boolean.TRUE;

            for (Occupation item : list) {

                if (item.getId () == 24) {
                    r = Boolean.FALSE;
                    break;
                }
            }

            Assert.assertTrue(r);

        } catch (Exception e) {

            Assert.assertNull(e);
        }
    }

    @Test
    public void testUpdate () {

        try {

            //Update one occupation.
            logger.info ("Starting occupation update test.");
            IOccupationDao dao = new OccupationDaoJDBC ();

            logger.debug ("Inserting new occupation.");
            Occupation occupation = new Occupation ();
            occupation.setId(1);
            occupation.setName ("Run update tester.");
            occupation.setDescription ("xxxxxxxx");

            dao.update (occupation);

            logger.debug ("Checking test result.");
            List<Occupation> list = dao.findAll ();

            boolean r = Boolean.FALSE;

            for (Occupation item : list) {

                if (item.getName ().equals (occupation.getName ())) {
                    r = Boolean.TRUE;
                    break;
                }
            }

            logger.info("Finishing the test...");
            Assert.assertTrue(r);

        } catch (Exception e) {

            Assert.assertNull(e);
        }
    }
}