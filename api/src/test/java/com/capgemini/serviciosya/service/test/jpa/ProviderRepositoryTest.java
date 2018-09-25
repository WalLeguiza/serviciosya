package com.capgemini.serviciosya.service.test.jpa;

import java.util.*;

import com.capgemini.serviciosya.beans.entity.*;
import com.capgemini.serviciosya.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import org.apache.log4j.Logger;

@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class ProviderRepositoryTest {

    @Autowired
    private IProviderRepository repositoryProvider = null;

    @Autowired
    private IOccupationRepository repositoryOccupation = null;

    @Autowired
    private ICityRepository repositoryCity = null;

    @Autowired
    private IProvinceRepository repositoryProvince = null;

    @Autowired
    private ICountryRepository repositoryCountry = null;

    private final Logger logger = Logger.getLogger(ProviderRepositoryTest.class);

    public ProviderRepositoryTest () {

        super ();
    }

    @Before
    public void setup () {

        logger.info ("Creating Occupation...");
        OccupationEntity[] occupations = new OccupationEntity[] {

                new OccupationEntity (Integer.valueOf (1), "Ingeniería", "Ingeniería"),
                new OccupationEntity (Integer.valueOf (2), "Ingeniero Nuclear", "Ingeniería Nuclear"),
                new OccupationEntity (Integer.valueOf (3), "Barredora", "Don Barredora"),
                new OccupationEntity (Integer.valueOf (4), "Cantinero", "Atención de barra"),

        };

        logger.debug ("Set countries father");
        occupations[1].setOccupation (occupations[0]);
        occupations[2].setOccupation (occupations[0]);
        logger.debug (String.format ("Object countries created %s", Arrays.toString(occupations)));

        logger.debug ("Saving occupations...");
        this.repositoryOccupation.save (Arrays.asList(occupations));
        logger.debug(String.format ("Occupations saved %s", Arrays.toString (occupations)));

        logger.info ("Creating city, province and country...");
        CountryEntity country = new CountryEntity (Integer.valueOf (1), "Stated United");
        ProvinceEntity province = new ProvinceEntity (Integer.valueOf (1), "Oregón", country);
        CityEntity city = new CityEntity (Integer.valueOf (1), "Springfield", province);

        logger.debug ("Saving city, province and country...");
        this.repositoryCountry.save (country);
        this.repositoryProvince.save (province);
        this.repositoryCity.save (city);
        logger.debug(String.format("City, province and country saved %s, %s, %s", city, province, country));

        logger.debug("Setting set countries...");
        Set<OccupationEntity> occupationHomer = new HashSet<OccupationEntity>();
        occupationHomer.add (occupations[1]);
        occupationHomer.add (occupations[2]);

        Set<OccupationEntity> occupationMoe = new HashSet<OccupationEntity>();
        occupationMoe.add(occupations[3]);

        logger.info("Creating provider...");
        ProviderEntity[] providers = new ProviderEntity[] {

                new ProviderEntity(Integer.valueOf(1), "Homero", "Simpsons",
                        "011-15-20541632", 20584963, "homer.simpsons@gmail.com",
                        "Siempre Viva 123", 0, city, occupationHomer),

                new ProviderEntity(Integer.valueOf(2), "Moe", "szyslak",
                        "011-15-45541632", 20654783, "moe.szyslak@gmail.com",
                        "Calle falsa 123", 0, city, occupationMoe)
        };

        logger.debug("Saving Providers...");
        this.repositoryProvider.save (Arrays.asList(providers));
        logger.debug(String.format("Providers saved %s", Arrays.toString(providers)));
    }

    @Test
    public void testFindAllByCity () {

        CityEntity city = new CityEntity ();
        city.setId (1);

        List<ProviderEntity> list = this.repositoryProvider.findAllByCity (city);

        for (ProviderEntity p : list) {

            System.out.println (p);
        }

        Assert.assertFalse ("There are providers", list.isEmpty ());
    }

    @Test
    public void testFindAllByCountry () {

        String email = "homer.simpsons@gmail.com";

        ProviderEntity p = this.repositoryProvider.findByEmail(email);

        System.out.println(p);

        Assert.assertNotNull ("There are providers", p);
    }

    @Test
    public void testFindAllByOccupations () {

        OccupationEntity o = new OccupationEntity();
        o.setId(2);

        List<ProviderEntity> p = this.repositoryProvider.findAllByOccupations(o);

        System.out.println(p);

        Assert.assertFalse ("There are providers", p.isEmpty());
    }
}
