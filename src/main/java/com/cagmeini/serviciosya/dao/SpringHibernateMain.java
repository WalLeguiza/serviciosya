package com.cagmeini.serviciosya.dao;

import com.cagmeini.serviciosya.beans.entity.CountryEntity;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ImportResource({ "classpath:applicationContext.xml" })
public class SpringHibernateMain {

    private static final Logger logger = Logger.getLogger (SpringHibernateMain.class);


    public SpringHibernateMain () {

        super ();
    }

    public static void main (String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");

        ICountryDao countryDao = context.getBean (ICountryDao.class);

        CountryEntity country = new CountryEntity();
        country.setName("Colombia");

        countryDao.create(country);

        logger.info (String.format ("Country  %s ", country.toString ()));

       /* List<Person> list = personDAO.list();

        for (Person p : list){

            logger.info (String.format ("Person  %s ", p.toString ()));
        }*/

        context.close();
    }
}
