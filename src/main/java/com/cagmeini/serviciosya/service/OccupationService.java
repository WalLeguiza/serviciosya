
package com.cagmeini.serviciosya.service;


import java.util.List;

import com.cagmeini.serviciosya.beans.domain.Occupation;
import com.cagmeini.serviciosya.dao.IOccupationDao;


public class OccupationService {


    private IOccupationDao occupationDao;


    public OccupationService () {

        super ();
    }

    public OccupationService (IOccupationDao occupationDao) {

        super ();

        this.occupationDao = occupationDao;
    }

    public void setOccupationDao(IOccupationDao occupationDao) {

        this.occupationDao = occupationDao;
    }

    public List<Occupation> findAllOccupations () {

        return this.occupationDao.findAllOccupations ();
    }

    public void addOccupation (Occupation occupation) {

        this.occupationDao.add (occupation);
    }

    public Occupation findByIdOccupation (String id) {

        return this.occupationDao.findById(id);
    }

    public void updateOccupation (String id, String name, String description) {

        this.occupationDao.update(id, name, description);
    }

    public void removeOccupation (Occupation occupation) {

        this.occupationDao.remove(occupation);
    }

    public void removeByIdOccupation (String id) {

        this.occupationDao.removeById(id);
    }
}