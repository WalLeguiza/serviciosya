package com.cagmeini.serviciosya.service.test;

import com.cagmeini.serviciosya.beans.domain.Country;
import com.cagmeini.serviciosya.dao.CountryDaoJDBC;
import com.cagmeini.serviciosya.dao.ICountryDao;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CountryServiceTest {

    private static final Logger logger = Logger.getLogger (CountryServiceTest.class);

    @Test
    public void testCreate () {

        try {

            //Insert new value
            logger.info ("Starting country add test.");
            ICountryDao dao = new CountryDaoJDBC();

            logger.debug ("Inserting new country.");
            Country country = new Country ();
            country.setName ("Venezuela");
            dao.create (country);

            logger.debug ("Checking test result.");
            List<Country> list = dao.findAll ();

            boolean r = Boolean.FALSE;

            for (Country item : list) {

                if (item.getName ().equals (country.getName ())) {
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
            logger.info("Starting country delete test.");
            ICountryDao dao = new CountryDaoJDBC();

            Country country = dao.findById(3);

            logger.debug ("Deleting one country.");
            dao.delete (country.getId());

            logger.debug ("Checking test result.");
            List<Country> list = dao.findAll ();

            boolean r = Boolean.TRUE;

            for (Country item : list) {

                if (item.getId () == 3) {
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
            logger.info ("Starting country update test.");
            ICountryDao dao = new CountryDaoJDBC ();

            logger.debug ("Inserting new country.");
            Country country = new Country ();
            country.setId(1);
            country.setName ("Argentina");

            dao.update (country);

            logger.debug ("Checking test result.");
            List<Country> list = dao.findAll ();

            boolean r = Boolean.FALSE;

            for (Country item : list) {

                if (item.getName ().equals (country.getName ())) {
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
