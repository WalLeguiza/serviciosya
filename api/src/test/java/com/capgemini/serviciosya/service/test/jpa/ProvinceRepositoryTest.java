package com.capgemini.serviciosya.service.test.jpa;

import java.util.*;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.repository.ICountryRepository;
import com.capgemini.serviciosya.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class ProvinceRepositoryTest {

    @Autowired
    private ICountryRepository repositoryCountry = null;

    @Autowired
    private IProvinceRepository repositoryProvince = null;


    private final Logger logger = LoggerFactory.getLogger (ProvinceRepositoryTest.class);


    public ProvinceRepositoryTest () {

        super ();
    }


    @Before
    public void setup () {

        logger.info ("Creating countries...");
        CountryEntity[] countries = new CountryEntity [] {

                new CountryEntity (Integer.valueOf (1), "Argentina"),
                new CountryEntity (Integer.valueOf (2), "Venezuela")
        };
        logger.debug (String.format ("Objects country created %s", Arrays.toString (countries)));

        logger.debug ("Saving countries...");
        this.repositoryCountry.save (Arrays.asList (countries));
        logger.debug (String.format ("Countries saved %s", Arrays.toString (countries)));


        logger.info ("Creating provinces...");
        ProvinceEntity[] provinces = new ProvinceEntity [] {

                new ProvinceEntity (Integer.valueOf (1), "Buenos Aires", countries[0]),
                new ProvinceEntity (Integer.valueOf (2), "Cordoba", countries[0]),
                new ProvinceEntity (Integer.valueOf (3), "Caracas", countries[1]),
                new ProvinceEntity (Integer.valueOf (4), "Corrientes", countries[0])
        };
        logger.debug (String.format ("Objects province created %s", Arrays.toString (countries)));

        logger.debug ("Saving provinces...");
        this.repositoryProvince.save (Arrays.asList (provinces));
        logger.debug (String.format ("Provinces saved %s", Arrays.toString (provinces)));
    }

    @Test
    public void testGetAllByCountry () {

        logger.info ("Getting provinces...");

        CountryEntity c = new CountryEntity ();
        c.setId (Integer.valueOf (1));

        List<ProvinceEntity> list = this.repositoryProvince.findAllByCountryOrderByName (c);

        for (ProvinceEntity p : list) {
            System.out.println(p);
        }

        Assert.assertNotNull ("There are provinces...", list);
        Assert.assertFalse ("There are provinces...", list.isEmpty ());
    }
}
