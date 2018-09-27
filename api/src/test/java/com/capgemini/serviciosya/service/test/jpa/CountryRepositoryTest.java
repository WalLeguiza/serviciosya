package com.capgemini.serviciosya.service.test.jpa;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.repository.ICountryRepository;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountryRepositoryTest {

    @Autowired
    private ICountryRepository repository = null;

    private static final Logger logger = Logger.getLogger(ICountryRepository.class);

    @Before
    public void setup () {

        logger.info ("Creating countries...");
        CountryEntity[] countries = new CountryEntity [] {

                new CountryEntity (Integer.valueOf (1), "Argentina"),
                new CountryEntity (Integer.valueOf (2), "Venezuela"),
                new CountryEntity (Integer.valueOf (3), "Uruguay"),
                new CountryEntity (Integer.valueOf (4), "Chile"),
                new CountryEntity (Integer.valueOf (5), "Peru")
        };
        logger.debug (String.format ("Objects country created %s", Arrays.toString (countries)));

        logger.debug ("Saving countries...");
        this.repository.save (Arrays.asList (countries));
        logger.debug (String.format ("Countries saved %s", Arrays.toString (countries)));
    }

    @Test
    public void testCount () {

        logger.info ("Counting countries...");
        Long count = this.repository.count ();

        Assert.assertNotNull ("There are countries...", count);
        Assert.assertTrue ("There are countries...",count == 5);
    }

    @Test
    public void testGetAll () {

        logger.info ("Getting countries...");
        List<CountryEntity> list = this.repository.findAll ();

        Assert.assertNotNull ("There are countries...", list);
        Assert.assertFalse ("There are countries...",list.isEmpty ());
    }

}
