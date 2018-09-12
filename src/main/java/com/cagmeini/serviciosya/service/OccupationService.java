
package com.cagmeini.serviciosya.service;

import com.cagmeini.serviciosya.beans.domain.Occupation;
import com.cagmeini.serviciosya.dao.IOccupationDao;
import sun.plugin.util.PluginConsoleController;

public class OccupationService {

    private IOccupationDao occupationDao;

    public OccupationService () {
        super();
    }

    public OccupationService (IOccupationDao occupationDao) {
        super();
        this.occupationDao = occupationDao;
    }
}