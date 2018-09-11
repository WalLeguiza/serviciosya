package com.cagmeini.serviciosya.dao;

import com.cagmeini.serviciosya.beans.domain.Occupation;

import java.util.List;

public class OccupationJdbcDao implements IOccupationDao {

  @Override
  public List<Occupation> findAllOccupations() {
    return null;
  }

  @Override
  public void add(Occupation occupation) {

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
