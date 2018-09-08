
package com.cagmeini.serviciosya.dao;


import java.util.List;

import com.cagmeini.serviciosya.beans.domain.Occupation;


public interface IOccupationDao {


    List<Occupation> findAllOccupations ();

    void add (Occupation occupation);
    
    Occupation findById(String id);

    void update (String id, String name, String description);

    void remove (Occupation occupation);

    void removeById (String id);
}
