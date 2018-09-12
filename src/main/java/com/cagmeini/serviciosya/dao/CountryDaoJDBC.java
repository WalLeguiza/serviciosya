package com.cagmeini.serviciosya.dao;

import com.cagmeini.serviciosya.beans.domain.Country;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class CountryDaoJDBC implements ICountryDao {

    private static final Logger logger = Logger.getLogger (CountryDaoJDBC.class);

    public CountryDaoJDBC() {

        super();
    }

    @Override
    public void create(Country country) {

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection connection = CapgeminiDB.getConnection ();

            String sql = "insert into country (name) values (?)";
            PreparedStatement ps = connection.prepareStatement (sql);
            ps.setString (1, country.getName ());

            // Execute the query.
            logger.debug (String.format ("Executing query [%s]", sql));
            int c = ps.executeUpdate ();

            // Read the result.
            if (c == 0) {

                throw new DaoException ("Failure inserting new country!");
            }

        } catch (SQLException e) {

            // Failure.
            logger.error ("Failure inserting new country!");
            throw new DaoException ("Failure inserting new country!", e);

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure inserting new country!");
            throw new DaoException (e.getMessage (), e);
        }
    }

    @Override
    public void update(Country country) {

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection connection = CapgeminiDB.getConnection ();

            String sql = "update country as c set name = ? where c.id = "+country.getId();
            PreparedStatement ps = connection.prepareStatement (sql);
            ps.setString (1, country.getName ());

            // Execute the query.
            logger.debug (String.format ("Executing query [%s]", sql));
            int c = ps.executeUpdate ();

            // Read the result.
            if (c == 0) {

                throw new DaoException ("Failure inserting new countries!");
            }

        } catch (SQLException e) {

            // Failure.
            logger.error ("Failure inserting new country!");
            throw new DaoException ("Failure inserting new country!", e);

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure inserting new country!");
            throw new DaoException (e.getMessage (), e);
        }
    }

    @Override
    public void delete(Integer id) {

        try {
            //Get connection.
            logger.debug("Getting new connection...");
            Connection connection = CapgeminiDB.getConnection();

            String sql = "delete from country where id = "+id;
            PreparedStatement ps = connection.prepareStatement(sql);

            logger.debug(String.format("Executing query [%s]", sql));

            ps.executeUpdate();

        } catch (SQLException e) {

            // Failure.
            logger.error ("Failure inserting new country!");
            throw new DaoException ("Failure inserting new country!", e);

        } catch (Exception e) {

            throw new DaoException(e.getMessage (), e);
        }
    }

    @Override
    public List<Country> findAll() {
        // Countries list.
        List<Country> countries = new ArrayList<> ();

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection conn = CapgeminiDB.getConnection ();

            Statement statement = conn.createStatement ();

            // Execute the query.
            String sql = "select * from country";
            logger.debug (String.format ("Executing query [%s]", sql));
            ResultSet rs = statement.executeQuery (sql);

            // Read the result.
            while (rs.next ()) {

                Country country = new Country ();
                country.setId (rs.getInt ("ID"));
                country.setName (rs.getString ("NAME"));

                // Add new object to list.
                countries.add (country);
            }

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure searching all countries");
            throw new DaoException ("Failure searching all countries", e);
        }

        // Return results.
        return countries;

    }

    @Override
    public Country findById(Integer id) {

        Country country = new Country ();

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection conn = CapgeminiDB.getConnection ();

            Statement statement = conn.createStatement ();

            // Execute the query.
            String sql = "select * from country where id = "+id;
            logger.debug (String.format ("Executing query [%s]", sql));
            ResultSet rs = statement.executeQuery (sql);

            while (rs.next ()) {
                country.setId(rs.getInt("ID"));
                country.setName(rs.getString("NAME"));
            }

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure searching all countries");
            throw new DaoException ("Failure searching all countries", e);
        }

        // Return results.
        return country;

    }
}
