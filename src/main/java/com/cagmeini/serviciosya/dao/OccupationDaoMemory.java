
package com.cagmeini.serviciosya.dao;


import java.util.*;

import static org.apache.commons.lang3.RandomStringUtils.*;

import com.cagmeini.serviciosya.beans.domain.Occupation;


public class OccupationDaoMemory implements IOccupationDao {


    private Map<String, Occupation> occupations;


    public OccupationDaoMemory() {

        super ();

        this.occupations = new TreeMap<>();

        // Load occupations.
        Occupation o1 = new Occupation (randomAlphabetic(5),
                                        "Entandador de Serpientes",
                                    "Entandador de Serpientes");

        Occupation o2 = new Occupation (randomAlphabetic(5),
                                       "Cuidador de Suegras",
                                   "Cuidador de Suegras");

        // Add values to map.
        this.occupations.put (o1.getId (), o1);
        this.occupations.put (o2.getId (), o2);
    }

    @Override
    public List<Occupation> findAllOccupations () {

        // Get the entries.
        Set<Map.Entry<String, Occupation>> entries = this.occupations.entrySet ();

        // Build the occupation list.
        List<Occupation> list = new ArrayList<> ();
        for (Map.Entry<String, Occupation> item: entries) {

            list.add (item.getValue ());
        }

        // Return the occupations.
        return list;
    }

    @Override
    public void add (Occupation occupation) {

        this.occupations.put (occupation.getId (), occupation);
    }

    @Override
    public Occupation findById (String id) throws NullPointerException{

       if(this.occupations.containsKey(id)) {
           return this.occupations.get(id);
       }

       throw new NullPointerException();
    }

    @Override
    public void update (String id, String name, String description) {

        Occupation o = this.findById(id);
        o.setName(name);
        o.setDescription(description);
        this.occupations.replace(id, o);
    }

    @Override
    public void remove(Occupation occupation) {

        this.occupations.remove(occupation.getId());

    }

    @Override
    public void removeById (String id) {

        if(this.occupations.containsKey(id)) {
            this.occupations.remove(id);
        }
    }
}