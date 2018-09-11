package com.cagmeini.serviciosya.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;

public class CapgeminiDB {

    private Connection cnn;

    private static final BasicDataSource datasource = new BasicDataSource();

    static {

    }

    public static final Connection getConnection () {

        return null;
    }

    public static final void closeConnection () throws Exception {

    }
}
