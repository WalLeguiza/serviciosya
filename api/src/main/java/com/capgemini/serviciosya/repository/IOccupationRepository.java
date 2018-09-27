
package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.OccupationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *  <p>The interface <code>com.capgemini.serviciosya.repository.IOccupationRepository<code/>
 *  is a dao object for manipulate the occupations information in the database.
 *
 *  @author Walter Leguiza (wal.leguiza@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */
@Repository
public interface IOccupationRepository extends JpaRepository <OccupationEntity, Integer> {

    /**
     *
     *  <p>Return the occupation searches by occupation (parent).
     *
     *  @return Return the provider list.
     * */
    List<OccupationEntity> findAllByOccupation (OccupationEntity occupation);
}
