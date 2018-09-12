package com.cagmeini.serviciosya.service.test;

import com.cagmeini.serviciosya.beans.domain.Province;
import com.cagmeini.serviciosya.dao.IProvinceDao;
import com.cagmeini.serviciosya.dao.ProvinceDaoJDBC;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProvinceServiceTest {

    private static final Logger logger = Logger.getLogger (ProvinceServiceTest.class);

    @Test
    public void testCreate () {

        try {

            //Insert new value
            logger.info ("Starting province add test.");
            IProvinceDao dao = new ProvinceDaoJDBC();

            logger.debug ("Inserting new province.");
            Province province = new Province ();
            province.setName ("Buenos Aires");
            province.setCountryId(1);

            dao.create (province);

            logger.debug ("Checking test result.");
            List<Province> list = dao.findAll ();

            boolean r = Boolean.FALSE;

            for (Province item : list) {

                if (item.getName ().equals (province.getName ())) {
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
            logger.info("Starting province delete test.");
            IProvinceDao dao = new ProvinceDaoJDBC();

            Province province = dao.findById(1);

            logger.debug ("Deleting one province.");
            dao.delete (province.getId());

            logger.debug ("Checking test result.");
            List<Province> list = dao.findAll ();

            boolean r = Boolean.TRUE;

            for (Province item : list) {

                if (item.getId () == 1) {
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
            logger.info ("Starting province update test.");
            IProvinceDao dao = new ProvinceDaoJDBC ();

            logger.debug ("Inserting new province.");
            Province province = new Province ();
            province.setId(1);
            province.setName ("Buenos Aires");
            province.setCountryId(1);

            dao.update (province);

            logger.debug ("Checking test result.");
            List<Province> list = dao.findAll ();

            boolean r = Boolean.FALSE;

            for (Province item : list) {

                if (item.getName ().equals (province.getName ())) {
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
