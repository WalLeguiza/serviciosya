package com.cagmeini.serviciosya.dao;

import com.cagmeini.serviciosya.beans.domain.Province;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProvinceDaoJDBC implements IProvinceDao{

    private static final Logger logger = Logger.getLogger (ProvinceDaoJDBC.class);

    public ProvinceDaoJDBC() {

        super();
    }

    @Override
    public void create(Province province) {

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection connection = CapgeminiDB.getConnection ();

            String sql = "insert into province (name, country_id) values (?, ?)";
            PreparedStatement ps = connection.prepareStatement (sql);
            ps.setString (1, province.getName ());
            ps.setString(2, String.valueOf(province.getCountryId()));

            // Execute the query.
            logger.debug (String.format ("Executing query [%s]", sql));
            int c = ps.executeUpdate ();

            // Read the result.
            if (c == 0) {

                throw new DaoException ("Failure inserting new province!");
            }

        } catch (SQLException e) {

            // Failure.
            logger.error ("Failure inserting new province!");
            throw new DaoException ("Failure inserting new province!", e);

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure inserting new province!");
            throw new DaoException (e.getMessage (), e);
        }
    }

    @Override
    public void update(Province province) {

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection connection = CapgeminiDB.getConnection ();

            String sql = "update province as p set name = ?, country_id = ? where p.id = "+province.getId();
            PreparedStatement ps = connection.prepareStatement (sql);
            ps.setString (1, province.getName ());

            // Execute the query.
            logger.debug (String.format ("Executing query [%s]", sql));
            int c = ps.executeUpdate ();

            // Read the result.
            if (c == 0) {

                throw new DaoException ("Failure inserting new provinces!");
            }

        } catch (SQLException e) {

            // Failure.
            logger.error ("Failure inserting new province!");
            throw new DaoException ("Failure inserting new province!", e);

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure inserting new province!");
            throw new DaoException (e.getMessage (), e);
        }
    }

    @Override
    public void delete(Integer id) {

        try {
            //Get connection.
            logger.debug("Getting new connection...");
            Connection connection = CapgeminiDB.getConnection();

            String sql = "delete from province where id = "+id;
            PreparedStatement ps = connection.prepareStatement(sql);

            logger.debug(String.format("Executing query [%s]", sql));

            ps.executeUpdate();

        } catch (SQLException e) {

            // Failure.
            logger.error ("Failure inserting new province!");
            throw new DaoException ("Failure inserting new province!", e);

        } catch (Exception e) {

            throw new DaoException(e.getMessage (), e);
        }
    }

    @Override
    public List<Province> findAll() {
        // Provinces list.
        List<Province> provinces = new ArrayList<> ();

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection conn = CapgeminiDB.getConnection ();

            Statement statement = conn.createStatement ();

            // Execute the query.
            String sql = "select * from province";
            logger.debug (String.format ("Executing query [%s]", sql));
            ResultSet rs = statement.executeQuery (sql);

            // Read the result.
            while (rs.next ()) {

                Province province = new Province ();
                province.setId (rs.getInt ("ID"));
                province.setName (rs.getString ("NAME"));
                province.setCountryId (rs.getInt ("COUNTRY_ID"));

                // Add new object to list.
                provinces.add (province);
            }

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure searching all provinces");
            throw new DaoException ("Failure searching all provinces", e);
        }

        // Return results.
        return provinces;

    }

    @Override
    public Province findById(Integer id) {

        Province province = new Province ();

        try {

            // Get connection.
            logger.debug ("Getting new connection...");
            Connection conn = CapgeminiDB.getConnection ();

            Statement statement = conn.createStatement ();

            // Execute the query.
            String sql = "select * from province where id = "+id;
            logger.debug (String.format ("Executing query [%s]", sql));
            ResultSet rs = statement.executeQuery (sql);

            while (rs.next ()) {
                province.setId(rs.getInt("ID"));
                province.setName(rs.getString("NAME"));
            }

        } catch (Exception e) {

            // Failure.
            logger.error ("Failure searching all provinces");
            throw new DaoException ("Failure searching all provinces", e);
        }

        // Return results.
        return province;

    }
}
