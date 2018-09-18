package com.cagmeini.serviciosya.dao;

import com.cagmeini.serviciosya.beans.entity.ProviderEntity;

public interface IProviderDao extends IDao<ProviderEntity, Integer> {

    ProviderEntity findByEmail (String email);

    ProviderEntity findByDNI (Integer dni);

    ProviderEntity findByPhone (String phone);
}
