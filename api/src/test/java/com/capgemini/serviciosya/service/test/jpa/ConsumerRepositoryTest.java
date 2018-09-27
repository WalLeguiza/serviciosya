package com.capgemini.serviciosya.service.test.jpa;

import java.util.*;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ConsumerEntity;
import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.repository.ICityRepository;
import com.capgemini.serviciosya.repository.IConsumerRepository;
import com.capgemini.serviciosya.repository.ICountryRepository;
import com.capgemini.serviciosya.repository.IProvinceRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class ConsumerRepositoryTest {

    @Autowired
    private IConsumerRepository repositoryConsumer = null;

    @Autowired
    private ICountryRepository repositoryCountry = null;

    @Autowired
    private IProvinceRepository repositoryProvince = null;

    @Autowired
    private ICityRepository repositoryCity = null;

    private static final Logger logger = Logger.getLogger(ConsumerRepositoryTest.class);

    public ConsumerRepositoryTest () {

        super ();
    }

    @Before
    public void setup () {

        logger.info("Creating city, province and country...");
        CountryEntity country = new CountryEntity (Integer.valueOf (1), "Stated United");
        ProvinceEntity province = new ProvinceEntity (Integer.valueOf (1), "Oregón", country);
        CityEntity city = new CityEntity (Integer.valueOf (1), "Springfield", province);

        logger.debug ("Saving city, province and country...");
        this.repositoryCountry.save (country);
        this.repositoryProvince.save (province);
        this.repositoryCity.save (city);
        logger.debug(String.format("City, province and country saved %s, %s, %s", city, province, country));

        logger.info("Creating provider...");
        ConsumerEntity[] consumers = new ConsumerEntity[] {

                new ConsumerEntity(Integer.valueOf(1), "Bart", "Simpsons",45584963,
                        "bart.simpsons@gmail.com", "011-15-20589632", city,
                        "Siempre viva 123", 0),

                new ConsumerEntity(Integer.valueOf(2), "Lisa", "Simpsons",48584963,
                        "lisa.simpsons@gmail.com", "011-15-25589632", city,
                        "Siempre viva 123", 0)
        };

        logger.debug("Saving Providers...");
        this.repositoryConsumer.save (Arrays.asList(consumers));
        logger.debug(String.format("Consumers saved %s", Arrays.toString(consumers)));
    }

    @Test
    public void testCountConsumer () {
        logger.info ("Counting countries...");
        long count = this.repositoryConsumer.count();

        Assert.assertNotNull("There are consumers", count);
        Assert.assertTrue("There are consumers", count==2);
    }

    @Test
    public void testFindAll () {

        logger.info("Getting consumers...");
        List<ConsumerEntity> list = this.repositoryConsumer.findAll();

        for (ConsumerEntity e : list) {

            System.out.println(e);
        }

        Assert.assertNotNull("There are consumers", list);
        Assert.assertFalse("There are consumers", list.isEmpty());
    }
}
