package com.cagmeini.serviciosya.dao;

import com.cagmeini.serviciosya.beans.domain.Occupation;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;


public class OccupationJdbcDao implements IOccupationDao {

  private Connection cnn;

  public void openConnection () throws Exception {

    // Register the driver.
    Class.forName ("org.postgresql.Driver");

    // Create a new connection.
    this.cnn = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/serviciosya", "postgres", "walter@localhost");
  }

  public void closeConnection () throws Exception {

    this.cnn.close ();
  }

  private List<Occupation> writeResultToList (ResultSet resultSet) throws SQLException {

    List<Occupation> list = new ArrayList<Occupation>();

    // ResultSet is initially before the first data set
    while (resultSet.next ()) {

      int id = resultSet.getInt ("ID");
      String name   = resultSet.getString ("NAME");
      String description = resultSet.getString("DESCRIPTION");

      Occupation occupation = new Occupation(String.valueOf(id), name, description);

      list.add(occupation);

    }

    return list;
  }

  @Override
  public List<Occupation> findAllOccupations() {

    try {

      this.openConnection();

      Statement stm = this.cnn.createStatement ();

      // Result set get the result of the SQL query
      ResultSet resultSet = stm.executeQuery ("SELECT * from \"OCCUPATION\"");

      return this.writeResultToList(resultSet);

    }catch (Exception e) {

    }finally {
      try {
        this.closeConnection();
      } catch (Exception e) {

      }
    }

    return null;
  }

 @Override
  public void add(Occupation occupation) {
/*
    try {
      this.openConnection();

      this.cnn.setAutoCommit (false);

      this.cnn.createStatement().executeUpdate("INSERT INTO \"OCCUPATION\" (\"NAME\", \"DESCRIPTION\") VALUES ("+occupation.getName()+", "+occupation.getDescription()+")");

      this.cnn.commit ();

    }catch (Exception e) {

      try {
        this.cnn.rollback ();
      } catch (Exception e2) {

        e.printStackTrace();
      }
    }finally {
      try {
        this.closeConnection();
      } catch (Exception e) {

      }
    }*/
  }

  @Override
  public Occupation findById(String id) {
    return null;
  }

  @Override
  public void update(String id, String name, String description) {

  }

  @Override
  public void remove(Occupation occupation) {

  }

  @Override
  public void removeById (String id) {

  }
}
