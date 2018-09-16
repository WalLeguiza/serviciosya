package com.cagmeini.serviciosya.service.test.orm;

import com.cagmeini.serviciosya.beans.entity.ConsumerEntity;
import com.cagmeini.serviciosya.beans.entity.ContractEntity;
import com.cagmeini.serviciosya.beans.entity.ProviderEntity;
import com.cagmeini.serviciosya.dao.IContractDao;
import com.cagmeini.serviciosya.dao.orm.ContractDaoHibernate;
import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ContractDaoTest {

    private IContractDao dao = new ContractDaoHibernate();

    @Test
    public void testCreate () {

        ContractEntity contract = new ContractEntity();
        ConsumerEntity consumer = new ConsumerEntity();
        ProviderEntity provider = new ProviderEntity();

        consumer.setId(2);
        provider.setId(1);

        contract.setConsumer(consumer);
        contract.setProvider(provider);
        contract.setDate(new GregorianCalendar());
        contract.setAmount(1580.5);
        contract.setStatus(0);

        dao.create(contract);

        Assert.assertNotNull("Failure creating new contract", contract);
    }
}
