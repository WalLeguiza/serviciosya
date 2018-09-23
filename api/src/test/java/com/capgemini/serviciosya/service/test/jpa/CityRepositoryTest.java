package com.capgemini.serviciosya.service.test.jpa;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.repository.ICityRepository;
import com.capgemini.serviciosya.repository.IProvinceRepository;
import com.capgemini.serviciosya.repository.ICountryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityRepositoryTest {

    @Autowired
    private ICountryRepository repositoryCountry = null;

    @Autowired
    private IProvinceRepository repositoryProvince = null;

    @Autowired
    private ICityRepository repositoryCity = null;


    private final Logger logger = LoggerFactory.getLogger (ICityRepository.class);

    @Before
    public void setup () {

        logger.info ("Creating countries...");
        CountryEntity[] countries = new CountryEntity [] {

                new CountryEntity (Integer.valueOf (1), "Argentina"),
                new CountryEntity (Integer.valueOf (2), "Venezuela")
        };

        logger.debug ("Saving countries...");
        this.repositoryCountry.save (Arrays.asList (countries));
        logger.debug (String.format ("Countries saved %s", Arrays.toString (countries)));


        logger.info ("Creating provinces...");
        ProvinceEntity[] provinces = new ProvinceEntity [] {

                new ProvinceEntity (Integer.valueOf (1), "Buenos Aires", countries[0]),
                new ProvinceEntity (Integer.valueOf (2), "Corrientes", countries[0])
        };
        logger.debug (String.format ("Objects province created %s", Arrays.toString (provinces)));

        logger.debug ("Saving provinces...");
        this.repositoryProvince.save (Arrays.asList (provinces));
        logger.debug (String.format ("Province saved %s", Arrays.toString (provinces)));


        logger.info ("Creating cities...");
        CityEntity[] cities = new CityEntity [] {

                new CityEntity (Integer.valueOf (1),"CABA", provinces[0]),
                new CityEntity (Integer.valueOf (2), "Quilmes", provinces[0]),
                new CityEntity (Integer.valueOf (3), "Parana", provinces[1]),
                new CityEntity (Integer.valueOf (4), "Florencio Varela", provinces[0] )
        };
        logger.debug (String.format ("Objects city created %s", Arrays.toString (cities)));

        logger.debug ("Saving cities...");
        this.repositoryCity.save (Arrays.asList (cities));
        logger.debug (String.format ("Cities saved %s", Arrays.toString (cities)));
    }

    @Test
    public void testGetAllByProvince () {

        logger.info ("Getting cities...");

        ProvinceEntity p = new ProvinceEntity ();
        p.setId (Integer.valueOf (2));

        List<CityEntity> list = this.repositoryCity.findAllByProvinceOrderByName (p);

        for (CityEntity city : list) {
            System.out.println(city.getName()+" -> "+city.getProvince().getName());
        }

        Assert.assertNotNull ("There are cities...", list);
        Assert.assertFalse ("There are cities...",list.isEmpty ());
    }

    @Test
    public void testGetByName () {

        logger.info ("Getting cities...");
        String name = "Varela";
        CityEntity city = this.repositoryCity.findByName (name);

        System.out.println(city);

        Assert.assertNotNull ("There are cities...", city);
    }
}
