package com.capgemini.serviciosya.service.test.jpa;

import com.capgemini.serviciosya.beans.entity.OccupationEntity;
import com.capgemini.serviciosya.repository.IOccupationRepository;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = JpaConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OccupationRepositoryTest {

    @Autowired
    private IOccupationRepository repository = null;

    private static final Logger logger = Logger.getLogger(OccupationRepositoryTest.class);

    public OccupationRepositoryTest () {

        super ();
    }

    @Before
    public void setup () {

        logger.info("Creating Occupation...");
        OccupationEntity[] occupations = new OccupationEntity[] {

                new OccupationEntity (Integer.valueOf(1), "Ingeniería", "Ingeniería"),
                new OccupationEntity (Integer.valueOf(2), "Ingeniería Informática", "Ingeniría Informática"),
                new OccupationEntity (Integer.valueOf(3), "Ingeniería Electrónica", "Ingeniría Electrónica")
        };

        logger.debug("Set countries father");
        occupations[1].setOccupation(occupations[0]);
        occupations[2].setOccupation(occupations[0]);

        logger.debug (String.format("Object countries created %s", Arrays.toString(occupations)));

        logger.debug("Saving occupations...");
        this.repository.save(Arrays.asList(occupations));
        logger.debug(String.format("Occupations saved %s", Arrays.toString(occupations)));
    }

    @Test
    public void testFindByAllOccupation () {

        OccupationEntity occupation = new OccupationEntity ();
        occupation.setId (1);

        List<OccupationEntity> list = this.repository.findAllByOccupation (occupation);

        for (OccupationEntity c : list) {

            System.out.println(c);
        }

        Assert.assertNotNull("There are occupations...", list);
        Assert.assertFalse("There are occupations...", list.isEmpty());
    }
}
