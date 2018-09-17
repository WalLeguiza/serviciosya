package com.cagmeini.serviciosya.service.test.orm;

import com.cagmeini.serviciosya.beans.entity.ConsumerEntity;
import com.cagmeini.serviciosya.beans.entity.ContractEntity;
import com.cagmeini.serviciosya.beans.entity.ProviderEntity;
import com.cagmeini.serviciosya.dao.IContractDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;

public class ContractDaoTest {

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");

    private IContractDao dao = context.getBean (IContractDao.class);

    @Test
    public void testCreate () {

        ContractEntity contract = new ContractEntity();
        ConsumerEntity consumer = new ConsumerEntity();
        ProviderEntity provider = new ProviderEntity();

        consumer.setId(4);
        provider.setId(2);

        contract.setConsumer(consumer);
        contract.setProvider(provider);
        contract.setDate(new GregorianCalendar());
        contract.setAmount(1980.5);
        contract.setStatus(0);

        dao.create(contract);

        Assert.assertNotNull("Failure creating new contract", contract);
    }
}
